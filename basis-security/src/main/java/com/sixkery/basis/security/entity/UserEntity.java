package com.sixkery.basis.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author sixkery
 * @date 2020/10/27
 */
@Data
@AllArgsConstructor
public class UserEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private Collection<? extends GrantedAuthority> role;
}
