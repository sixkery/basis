package com.sixkery.basis.es.service;

import com.sixkery.basis.es.mapper.UserMapper;
import com.sixkery.basis.es.mapper.vo.UserVo;
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
    public UserVo findByUsername(String username) {
        return userMapper.findUsername(username);
    }

    @Override
    public UserVo findByMobile(String mobile) {
        return userMapper.findByMobile(mobile);
    }

    @Override
    public UserVo findByEmail(String email) {
        return userMapper.findByEmail(email);
    }


}
