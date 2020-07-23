package com.sixkery.authentication.token;

/**
 * Create by Maoning in 2019/11/7
 */
public class JwtAuthenticationToken implements Authentication {

    private boolean isAuthenticated;

    private final Object principal;

    public JwtAuthenticationToken(Object principal) {
        this.principal = principal;
    }

    @Override
    public Object principal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.isAuthenticated = authenticated;
    }
}
