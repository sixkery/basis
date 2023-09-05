package com.sixkery.basis.es.service;

import com.sixkery.basis.es.config.SecurityUserDetails;
import com.sixkery.basis.es.mapper.vo.UserVo;
import com.sixkery.utils.NameUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 实现官方的 UserDetailsService 接口 从数据库中获取用户信息
 *
 * @author sixkery
 * @date 2020/10/27
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserVo userVo;
        if (NameUtil.username(username)) {
            userVo = userService.findByUsername(username);
        } else if (NameUtil.email(username)) {
            userVo = userService.findByEmail(username);
        } else {
            userVo = userService.findByMobile(username);
        }
        if (userVo == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        return new SecurityUserDetails(userVo);
    }
}
