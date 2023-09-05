package com.sixkery.basis.es.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sixkery
 * @date 2020/10/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;
    /**
     * 状态
     */
    private Integer status;
}
