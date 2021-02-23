package com.sixkery.basis.security.config;


import com.sixkery.basis.security.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Exrickx
 */
@Slf4j
public class SecurityUserDetails extends UserDO implements UserDetails {


    public SecurityUserDetails(UserDO user) {

        if (user != null) {
            // Principal用户信息
            this.setUsername(user.getUsername());
            this.setPassword(user.getPassword());
            this.setStatus(user.getStatus());

            this.permissions = user.getPermissions();
            this.roles = user.getRoles();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}