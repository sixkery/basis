package com.sixkery.access;


import com.sixkery.authentication.token.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 授权服务
 * @author sixkery
 */
public interface AuthorizeService {

    /**
     * 是否有权限
     * @param authentication 认证方式
     * @param request request
     * @return 是否有权限
     */
    boolean hasPermission(Authentication authentication, HttpServletRequest request);

}
