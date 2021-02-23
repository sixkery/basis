package com.sixkery.basis.security.service;

import com.sixkery.basis.security.entity.UserDO;
import com.sixkery.basis.security.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sixkery
 * @date 2020/10/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    /**
     * 根据用户名获得用户信息
     *
     * @param username 用户名
     * @return 用户信息，密码，权限 等
     */
    @Override
    public UserDO findByUsername(String username) {
        return userMapper.findUsername(username);
    }

    @Override
    public UserDO findByMobile(String mobile) {
        return null;
    }

    @Override
    public UserDO findByEmail(String email) {
        return null;
    }


}
