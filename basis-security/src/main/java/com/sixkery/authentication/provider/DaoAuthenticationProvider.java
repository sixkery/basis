package com.sixkery.authentication.provider;

import com.blinkframework.security.portal.authentication.UserDetails;
import com.blinkframework.security.portal.authentication.UserDetailsService;
import com.blinkframework.security.portal.authentication.token.Authentication;
import com.blinkframework.security.portal.authentication.token.UsernamePasswordAuthenticationToken;
import com.blinkframework.security.portal.exception.AuthenticationException;
import com.blinkframework.security.portal.exception.BadCredentialsException;
import com.blinkframework.security.portal.exception.UserNotFoundException;
import com.blinkframework.security.portal.util.PasswordEncoder;

/**
 * 用户名密码认证
 *
 * Create by Maoning in 2019/11/7
 */
public class DaoAuthenticationProvider extends AbstractAuthenticationProvider {

    private PasswordEncoder passwordEncoder;

    private UserDetailsService userDetailsService;

    @Override
    protected Authentication doAuthenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;

        String username = (String) authentication.principal();
        UserDetails userDetails = userDetailsService.loadByUsername(username);

        if (userDetails == null) {
            throw new UserNotFoundException();
        }

        // Match password
        if (!passwordEncoder.matches(authenticationToken.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException();
        }

        return new UsernamePasswordAuthenticationToken(userDetails);
    }

    @Override
    public boolean support(Class<?> auth) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth);
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
