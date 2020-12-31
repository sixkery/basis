package com.sixkery.basis.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.sixkery.basis.api.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询用户信息
     *
     * @return 返回结果
     */
    PageInfo findAll();

}
