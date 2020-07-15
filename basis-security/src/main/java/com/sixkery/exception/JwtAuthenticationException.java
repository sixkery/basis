package com.sixkery.exception;

import io.jsonwebtoken.JwtException;

/**
 * Create by Maoning in 2019/11/7
 */
public class JwtAuthenticationException extends AuthenticationException {

    private JwtException exception;

    public JwtAuthenticationException(JwtException e) {
        this.exception = e;
    }

    public JwtException getException() {
        return exception;
    }
}
