package com.sixkery.basis.security.service;

import com.sixkery.basis.security.entity.UserDO;

/**
 * @author sixkery
 * @date 2020/10/27
 */

public interface UserService {


    /**
     * 根据用户名获得用户信息
     *
     * @param username 用户名
     * @return 用户信息，密码，权限 等
     */
    public UserDO findByUsername(String username);


    /**
     * 根据手机号获得用户信息
     *
     * @param mobile 手机号
     * @return 用户信息，密码，权限 等
     */
    public UserDO findByMobile(String mobile);


    /**
     * 根据邮箱获得用户信息
     *
     * @param email 邮箱
     * @return 用户信息，密码，权限 等
     */
    public UserDO findByEmail(String email);

}
