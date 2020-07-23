package com.sixkery.configuration;

import com.blinkframework.security.portal.SecurityFilterChain;
import com.blinkframework.security.portal.authentication.AuthenticationManager;
import com.blinkframework.security.portal.authentication.AuthenticationManagerImpl;
import com.blinkframework.security.portal.authentication.filter.SecurityContextCacheClearFilter;
import com.blinkframework.security.portal.configuration.configurer.*;
import com.blinkframework.security.portal.properties.JwtProperties;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by Maoning in 2019/11/12
 */
public class HttpSecurity extends AbstractConfiguredSecurityBuilder<Filter, HttpSecurity>
        implements SecurityBuilder<Filter> {

    private List<Filter> filters;
    private AuthenticationManager authenticationManager;

    public HttpSecurity() {
        this.filters = new ArrayList<>();
        this.filters.add(new SecurityContextCacheClearFilter());
        this.authenticationManager = new AuthenticationManagerImpl();
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public AuthenticationManager authenticationManager() {
        return this.authenticationManager;
    }

    public FilterSecurityInterceptorConfigurer authorizeRequests() {
        FilterSecurityInterceptorConfigurer configurer = new FilterSecurityInterceptorConfigurer();
        apply(configurer);
        return configurer;
    }

    public FormLoginConfigurer formLogin() {
        FormLoginConfigurer formLoginConfigurer = new FormLoginConfigurer();
        apply(formLoginConfigurer);
        return formLoginConfigurer;
    }

    public JwtAuthenticationConfigurer jwt(JwtProperties properties) {
        JwtAuthenticationConfigurer configurer = new JwtAuthenticationConfigurer(properties);
        apply(configurer);
        return configurer;
    }

    public CorsConfigurer cors() {
        CorsConfigurer configurer = new CorsConfigurer();
        apply(configurer);
        return configurer;
    }

    public OpenidAuthenticationConfigurer openid() {
        OpenidAuthenticationConfigurer configurer = new OpenidAuthenticationConfigurer();
        apply(configurer);
        return configurer;
    }

    @Override
    protected Filter doBuild() {
        return new SecurityFilterChain(filters);
    }

}
