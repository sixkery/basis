package com.sixkery.authentication.token;

/**
 * Create by Maoning in 2019/11/6
 */
public interface Authentication {

    Object principal();

    boolean isAuthenticated();

}
