package com.sixkery.basis.security.service;

import com.sixkery.basis.security.entity.UserDO;
import org.springframework.security.core.userdetails.User;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userService.findByUsername(username);
        if (userDO == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        return new User(userDO.getUsername(), userDO.getPassword(), userDO.getAuthorities());
    }
}
