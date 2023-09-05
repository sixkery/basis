package com.sixkery.basis.es.service;

import com.sixkery.basis.es.mapper.vo.UserVo;

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
    public UserVo findByUsername(String username);


    /**
     * 根据手机号获得用户信息
     *
     * @param mobile 手机号
     * @return 用户信息，密码，权限 等
     */
    public UserVo findByMobile(String mobile);


    /**
     * 根据邮箱获得用户信息
     *
     * @param email 邮箱
     * @return 用户信息，密码，权限 等
     */
    public UserVo findByEmail(String email);

}
