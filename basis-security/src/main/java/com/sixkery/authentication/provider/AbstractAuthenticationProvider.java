package com.sixkery.authentication.provider;

import com.blinkframework.security.portal.authentication.UserDetails;
import com.blinkframework.security.portal.authentication.token.Authentication;
import com.blinkframework.security.portal.exception.AuthenticationException;
import com.blinkframework.security.portal.exception.UserDisabledException;

/**
 * Abstract authentication provider, mainly charge check user status.
 *
 * @author maoning
 */
public abstract class AbstractAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证信息
        Authentication auth = doAuthenticate(authentication);

        UserDetails userDetails = (UserDetails) auth.principal();

        // 检查用户状态
        if (!userDetails.isEnabled()) {
            throw new UserDisabledException();
        }

        return auth;
    }

    protected abstract Authentication doAuthenticate(Authentication authentication)
            throws AuthenticationException;
}
