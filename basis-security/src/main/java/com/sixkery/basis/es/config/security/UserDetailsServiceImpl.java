package com.sixkery.basis.es.config.security;

import com.sixkery.basis.es.mapper.UserMapper;
import com.sixkery.basis.es.mapper.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * 实现 security 登录的接口
 *
 * @author sixkery
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserVo userVo = userMapper.findUsername(username);


        return null;
    }
}
