package com.sixkery.basis.es.config.jwt;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.sixkery.basis.es.config.properties.TokenProperties;
import com.sixkery.basis.es.domain.dto.TokenUserDto;
import com.sixkery.basis.es.util.RedisUtil;
import com.sixkery.basis.es.util.constant.SecurityConstant;
import com.sixkery.utils.ResponseUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 登录成功处理器
 *
 * @author sixkery
 * @date 2020/10/27
 */
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Resource
    private TokenProperties tokenProperties;


    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        // 用户选择保存登录状态几天(记住我)
        String saveLogin = request.getParameter(SecurityConstant.SAVE_LOGIN);
        boolean saved = false;
        if (StrUtil.isNotBlank(saveLogin) && Boolean.parseBoolean(saveLogin)) {
            saved = true;
            if (!tokenProperties.getRedis()) {
                tokenProperties.setTokenExpireTime(tokenProperties.getSaveLoginTime() * 60 * 24);
            }
        }


        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) ((UserDetails) authentication.getPrincipal()).getAuthorities();
        List<String> list = new ArrayList<>();
        for (GrantedAuthority g : authorities) {
            list.add(g.getAuthority());
        }
        // 登陆成功生成 token
        String token;
        if (tokenProperties.getRedis()) {
            // redis
            token = IdUtil.simpleUUID();
            TokenUserDto user = new TokenUserDto(username, list, saved);
            // 不缓存权限
            if (!tokenProperties.getStorePerms()) {
                user.setPermissions(null);
            }
            // 单设备登录 之前的 token 失效
            if (tokenProperties.getSdl()) {
                String oldToken = redisUtil.get(SecurityConstant.USER_TOKEN + username);
                if (StrUtil.isNotBlank(oldToken)) {
                    redisUtil.delKey(SecurityConstant.TOKEN_PRE + oldToken);
                }
            }
            if (saved) {
                redisUtil.set(SecurityConstant.USER_TOKEN + username, token, tokenProperties.getSaveLoginTime(), TimeUnit.DAYS);
                redisUtil.set(SecurityConstant.TOKEN_PRE + token, new Gson().toJson(user), tokenProperties.getSaveLoginTime(), TimeUnit.DAYS);
            } else {
                redisUtil.set(SecurityConstant.USER_TOKEN + username, token, tokenProperties.getTokenExpireTime(), TimeUnit.MINUTES);
                redisUtil.set(SecurityConstant.TOKEN_PRE + token, new Gson().toJson(user), tokenProperties.getTokenExpireTime(), TimeUnit.MINUTES);
            }
        } else {
            // JWT不缓存权限 避免JWT长度过长
            list = null;
            // JWT
            token = SecurityConstant.TOKEN_SPLIT + Jwts.builder()
                    // 主题 放入用户名
                    .setSubject(username)
                    // 自定义属性 放入用户拥有请求权限
                    .claim(SecurityConstant.AUTHORITIES, new Gson().toJson(list))
                    // 失效时间
                    .setExpiration(new Date(System.currentTimeMillis() + tokenProperties.getTokenExpireTime() * 60 * 1000))
                    // 签名算法和密钥
                    .signWith(SignatureAlgorithm.HS512, SecurityConstant.JWT_SIGN_KEY)
                    .compact();
        }

        ResponseUtil.out(response, ResponseUtil.resultMap(true, 200, "登录成功", token));


    }
}