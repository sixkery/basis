package com.sixkery.basis.security.config.security;

import com.sixkery.basis.security.entity.UserDO;
import com.sixkery.basis.security.mapper.UserMapper;
import com.sixkery.basis.security.mapper.vo.UserVo;
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
