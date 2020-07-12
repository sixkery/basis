package com.sixkery;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 简单的登录认证流程
 *
 * @author sixkery
 * @date 2020/5/24
 */
public class SecurityExample {

    private static AuthenticationManager am = new SampleAuthenticationManager();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("请输入用户名：");
            String username = reader.readLine();
            System.out.println("请输入密码：");
            String password = reader.readLine();

            try {
                Authentication request = new UsernamePasswordAuthenticationToken(username, password);
                Authentication authenticate = am.authenticate(request);
                SecurityContextHolder.getContext().setAuthentication(authenticate);

            } catch (AuthenticationException e) {
                System.out.println("认证失败：" + e.getMessage());
            }
            System.out.println("认证成功!");
            System.out.println("安全上下文中的内容：" + SecurityContextHolder.getContext().getAuthentication());
        }
    }
}

class SampleAuthenticationManager implements AuthenticationManager {
    // 权限列表
    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

    static {
        // 添加一个角色
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public Authentication authenticate(Authentication auth) throws org.springframework.security.core.AuthenticationException {
        if (auth.getName().equals(auth.getPrincipal())) {
            return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
        }
        throw new BadCredentialsException("认证失败！");
    }
}