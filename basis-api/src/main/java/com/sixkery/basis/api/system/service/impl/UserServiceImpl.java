package com.sixkery.basis.api.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sixkery.basis.api.system.entity.User;
import com.sixkery.basis.api.system.mapper.UserMapper;
import com.sixkery.basis.api.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> findAll() {
        IPage<User> page = new Page<>(1L, 8L);
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.select();
        IPage<User> userIPage = userMapper.selectPage(page, objectQueryWrapper);
        return userIPage;


    }
}
