package com.sixkery.configuration.configurer;

import com.blinkframework.security.portal.access.AuthorizeService;
import com.blinkframework.security.portal.access.FilterSecurityInterceptor;
import com.blinkframework.security.portal.configuration.HttpSecurity;
import com.blinkframework.security.portal.configuration.SecurityConfigurerAdapter;

import javax.servlet.Filter;
import java.util.List;
import java.util.Map;

public class FilterSecurityInterceptorConfigurer extends SecurityConfigurerAdapter<Filter, HttpSecurity> {

    private String[] authenticated;

    private AuthorizeService authorizeService;

    private Map<String, List<String>> permissions;

    public FilterSecurityInterceptorConfigurer authenticated(String... authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    public FilterSecurityInterceptorConfigurer authorizeService(AuthorizeService authorizeService) {
        this.authorizeService = authorizeService;
        return this;
    }

    public FilterSecurityInterceptorConfigurer permissions(Map<String, List<String>> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public void configure(HttpSecurity builder) {
        FilterSecurityInterceptor filter = new FilterSecurityInterceptor();
        filter.setAuthenticated(authenticated);
        filter.setAuthorizeService(authorizeService);
        filter.setPermissions(permissions);
        filter.initialization();
        builder.addFilter(filter);
    }
}
