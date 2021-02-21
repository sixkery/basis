package com.sixkery.basis.security.mapper;


import com.sixkery.basis.security.entity.UserEntity;

/**
 * @author sixkery
 */
public interface UserMapper {

    /**
     * 根据用户名查找用户实体
     *
     * @param username 用户名
     * @return 用户实体
     */
    UserEntity findUsername(String username);
}
