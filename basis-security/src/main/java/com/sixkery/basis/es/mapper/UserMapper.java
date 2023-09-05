package com.sixkery.basis.es.mapper;


import com.sixkery.basis.es.mapper.vo.UserVo;

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
    UserVo findUsername(String username);

    /**
     * 根据用户名查找用户实体
     *
     * @param mobile 用户名
     * @return 用户实体
     */
    UserVo findByMobile(String mobile);

    /**
     * 根据用户名查找用户实体
     *
     * @param email 用户名
     * @return 用户实体
     */
    UserVo findByEmail(String email);
}
