package com.sixkery.basis.security.service;

import com.sixkery.basis.security.entity.UserEntity;
import com.sixkery.basis.security.mapper.UserMapper;
import com.sixkery.basis.security.util.JwtUtil;
import com.sixkery.response.ApiResponses;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sixkery
 * @date 2020/10/27
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailServiceImpl userDetailService;

    @Resource
    private JwtUtil jwtUtil;

    /**
     * 根据用户名获得用户信息
     *
     * @param username 用户名
     * @return 用户信息，密码，权限 等
     */
    public UserEntity findByUsername(String username) {
        return userMapper.findUsername(username);
    }

    public ApiResponses login(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        return ApiResponses.ok(jwtUtil.generateToken(userDetails));
    }

}
