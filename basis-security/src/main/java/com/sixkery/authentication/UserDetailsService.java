package com.sixkery.authentication;

import com.blinkframework.security.portal.exception.AuthenticationException;

/**
 * Create by Maoning in 2019/11/7
 */
public interface UserDetailsService {

    default UserDetails loadByOpenid(String openid) throws AuthenticationException {
        return null;
    }

    default UserDetails loadByUsername(String username) throws AuthenticationException {
        return null;
    }

}
