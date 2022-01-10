package com.sixkery.basis.security.config.jwt;

import cn.hutool.core.util.StrUtil;
import com.sixkery.basis.security.config.properties.TokenProperties;
import com.sixkery.basis.security.util.RedisUtil;
import com.sixkery.exception.LoginFailLimitException;
import com.sixkery.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 登录失败处理器
 *
 * @author sixkery
 * @date 2020/10/27
 */
@Slf4j
@Component
public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Resource
    private TokenProperties tokenProperties;

    @Resource
    private RedisUtil redisUtil;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        // 如果是 用户名不正确或者密码不正确
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            String username = request.getParameter("username");
            recordLoginTime(username);
            String key = "loginTimeLimit:" + username;
            String value = redisUtil.get(key);
            if (StrUtil.isBlank(value)) {
                value = "0";
            }
            //获取已登录错误次数
            int loginFailTime = Integer.parseInt(value);
            int restLoginTime = tokenProperties.getLoginTimeLimit() - loginFailTime;
            log.info("用户" + username + "登录失败，还有" + restLoginTime + "次机会");
            if (restLoginTime <= 3 && restLoginTime > 0) {
                ResponseUtil.out(response, ResponseUtil.resultMap(false, 500, "用户名或密码错误，还有" + restLoginTime + "次尝试机会"));
            } else if (restLoginTime <= 0) {
                ResponseUtil.out(response, ResponseUtil.resultMap(false, 500, "登录错误次数超过限制，请" + tokenProperties.getLoginAfterTime() + "分钟后再试"));
            } else {
                ResponseUtil.out(response, ResponseUtil.resultMap(false, 500, "用户名或密码错误"));
            }
        } else if (e instanceof DisabledException) {
            ResponseUtil.out(response, ResponseUtil.resultMap(false, 500, "账户被禁用，请联系管理员"));
        }  else {
            ResponseUtil.out(response, ResponseUtil.resultMap(false, 500, "登录失败，其他内部错误"));
        }

    }

    /**
     * 判断用户登录错误次数
     *
     * @param username 用户名
     * @return 是否还有重试的机会
     */
    private boolean recordLoginTime(String username) {
        String key = "loginTimeLimit" + username;
        String flagKey = "loginFailFlag" + username;
        String value = redisUtil.get(key);
        if (StrUtil.isBlank(value)) {
            value = "0";
        }
        // 获取已登录错误次数
        int loginFailTime = Integer.parseInt(value) + 1;
        redisUtil.set(key, Integer.toString(loginFailTime), tokenProperties.getLoginAfterTime(), TimeUnit.MINUTES);

        if (loginFailTime > tokenProperties.getLoginTimeLimit()) {
            redisUtil.set(flagKey, "fail", tokenProperties.getLoginAfterTime(), TimeUnit.MINUTES);
            return false;
        }
        return true;

    }
}