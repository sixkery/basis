package com.sixkery.basis.security.service;

import com.sixkery.basis.security.entity.UserEntity;
import com.sixkery.basis.security.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sixkery
 * @date 2020/10/27
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public UserEntity findByUsername(String username) {
        return userMapper.findUsername(username);
    }
}
