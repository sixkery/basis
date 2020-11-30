package com.sixkery.basis.api.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sixkery.basis.api.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
public interface UserService extends IService<User> {

    IPage<User> findAll();

}
