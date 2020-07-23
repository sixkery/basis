package com.sixkery.authentication.provider;

import com.blinkframework.security.portal.authentication.token.Authentication;
import com.blinkframework.security.portal.exception.AuthenticationException;

/**
 * Create by Maoning in 2019/11/7
 */
public interface AuthenticationProvider{

    Authentication authenticate(Authentication authentication) throws AuthenticationException;

    boolean support(Class<?> auth);

}
