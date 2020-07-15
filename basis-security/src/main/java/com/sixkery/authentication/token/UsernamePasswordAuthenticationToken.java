package com.sixkery.authentication.token;

/**
 * Create by Maoning in 2019/11/7
 */
public class UsernamePasswordAuthenticationToken implements Authentication {

    private boolean isAuthenticated;

    private final Object principal;

    private final String password;

    public UsernamePasswordAuthenticationToken(Object principal) {
        this.principal = principal;
        this.password = null;
        setAuthenticated(true);
    }

    public UsernamePasswordAuthenticationToken(String username, String password) {
        this.principal = username;
        this.password = password;
    }

    @Override
    public Object principal() {
        return principal;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }
}
