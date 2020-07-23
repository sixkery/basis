package com.sixkery;


import com.sixkery.authentication.token.Authentication;

/**
 * @author sixkery
 */
public interface SecurityContext {

    /**
     * 获取身份认证信息
     * @return 身份认证
     */
    Authentication getAuthentication();

    void setAuthentication(Authentication authentication);

}
