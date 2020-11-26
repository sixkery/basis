package com.sixkery.basis.api.system.service.impl;

import com.sixkery.basis.api.system.entity.User;
import com.sixkery.basis.api.system.mapper.UserMapper;
import com.sixkery.basis.api.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
