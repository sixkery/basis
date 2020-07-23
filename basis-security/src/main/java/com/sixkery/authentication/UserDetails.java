package com.sixkery.authentication;

import java.io.Serializable;
import java.util.Collection;

/**
 * Create by Maoning in 2019/11/7
 */
public interface UserDetails {

    Serializable getId();

    String getUsername();

    String getPassword();

    Collection<String> getAuthorities();

    boolean isEnabled();

}
