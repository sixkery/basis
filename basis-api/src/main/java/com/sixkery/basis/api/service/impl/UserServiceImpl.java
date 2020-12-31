package com.sixkery.basis.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.sixkery.basis.api.entity.User;
import com.sixkery.basis.api.mapper.UserMapper;
import com.sixkery.basis.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public PageInfo findAll() {
        PageMethod.startPage(1, 8);
        List<User> list = list();
        return new PageInfo<>(list);


    }
}
