package com.sixkery.basis.security.config.jwt;

import com.sixkery.basis.security.config.properties.TokenProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * JWT 过滤器
 *
 * @author: sixkery
 * @date:2021/3/29
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private TokenProperties tokenProperties;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
}
