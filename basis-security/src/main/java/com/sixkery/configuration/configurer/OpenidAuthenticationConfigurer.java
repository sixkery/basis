package com.sixkery.configuration.configurer;

import com.blinkframework.security.portal.authentication.AuthenticationManager;
import com.blinkframework.security.portal.authentication.UserDetailsService;
import com.blinkframework.security.portal.authentication.filter.OpenidAuthenticationFilter;
import com.blinkframework.security.portal.authentication.provider.OpenidAuthenticationProvider;
import com.blinkframework.security.portal.configuration.HttpSecurity;
import com.blinkframework.security.portal.configuration.SecurityConfigurerAdapter;
import com.blinkframework.security.portal.properties.JwtProperties;

import javax.servlet.Filter;

public class OpenidAuthenticationConfigurer extends SecurityConfigurerAdapter<Filter, HttpSecurity> {

    private String appid;

    private String secret;

    private JwtProperties jwtProperties;

    private UserDetailsService userDetailsService;

    public OpenidAuthenticationConfigurer appid(String appid) {
        this.appid = appid;
        return this;
    }

    public OpenidAuthenticationConfigurer secret(String secret) {
        this.secret = secret;
        return this;
    }

    public OpenidAuthenticationConfigurer jwtProperties(JwtProperties properties) {
        this.jwtProperties = properties;
        return this;
    }

    public OpenidAuthenticationConfigurer userDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        return this;
    }

    @Override
    public void configure(HttpSecurity builder) {
        OpenidAuthenticationFilter filter = new OpenidAuthenticationFilter(this.jwtProperties);

        AuthenticationManager authenticationManager = builder.authenticationManager();
        OpenidAuthenticationProvider provider = new OpenidAuthenticationProvider();
        provider.setAppid(this.appid);
        provider.setSecret(this.secret);
        provider.setUserDetailsService(this.userDetailsService);
        authenticationManager.registerProvider(provider);

        filter.setAuthenticationManager(authenticationManager);

        builder.addFilter(filter);
    }

}
