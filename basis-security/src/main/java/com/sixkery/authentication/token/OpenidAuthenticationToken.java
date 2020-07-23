package com.sixkery.authentication.token;

/**
 * 写点注释吧，求你了!!!/\^_^/\
 *
 * @author maoning
 */
public class OpenidAuthenticationToken implements Authentication {

    private final Object principal;

    private boolean isAuthenticated;

    public OpenidAuthenticationToken(Object principal) {
        this.principal = principal;
    }

    @Override
    public Object principal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.isAuthenticated = authenticated;
    }
}
