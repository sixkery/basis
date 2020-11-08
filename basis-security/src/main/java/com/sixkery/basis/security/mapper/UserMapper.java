package com.sixkery.basis.security.mapper;


import com.sixkery.basis.security.entity.UserEntity;

public interface UserMapper {

    UserEntity findUsername(String username);
}
