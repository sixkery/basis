package com.sixkery.authentication;

import java.util.Collection;
import java.util.Collections;

/**
 * @author sixkery
 */
public abstract class AbstractUserDetails implements UserDetails {

    @Override
    public Collection<String> getAuthorities() {
        return Collections.emptyList();
    }

}
