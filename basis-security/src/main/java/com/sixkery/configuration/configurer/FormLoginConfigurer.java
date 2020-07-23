package com.sixkery.configuration.configurer;

import com.blinkframework.security.portal.authentication.AuthenticationManager;
import com.blinkframework.security.portal.authentication.UserDetailsService;
import com.blinkframework.security.portal.authentication.filter.UsernamePasswordAuthenticationFilter;
import com.blinkframework.security.portal.authentication.provider.DaoAuthenticationProvider;
import com.blinkframework.security.portal.configuration.HttpSecurity;
import com.blinkframework.security.portal.configuration.SecurityConfigurerAdapter;
import com.blinkframework.security.portal.properties.JwtProperties;
import com.blinkframework.security.portal.util.PasswordEncoder;
import com.blinkframework.security.portal.util.bcrypt.BCryptPasswordEncoder;

import javax.servlet.Filter;

/**
 * Create by Maoning in 2019/11/12
 */
public class FormLoginConfigurer extends SecurityConfigurerAdapter<Filter, HttpSecurity> {

    private JwtProperties jwtProperties;

    private PasswordEncoder passwordEncoder;

    private UserDetailsService userDetailsService;

    public FormLoginConfigurer passwordEncoder(PasswordEncoder encoder) {
        this.passwordEncoder = encoder;
        return this;
    }

    public FormLoginConfigurer jwtProperties(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        return this;
    }

    public FormLoginConfigurer userDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        return this;
    }


    @Override
    public void configure(HttpSecurity http) {

        beforeConfigure();

        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);

        AuthenticationManager authenticationManager = http.authenticationManager();
        authenticationManager.registerProvider(provider);

        filter.setJwtProperties(jwtProperties);
        filter.setAuthenticationManager(authenticationManager);

        http.addFilter(filter);
    }

    private void beforeConfigure() {
        if (passwordEncoder == null) {
            passwordEncoder = new BCryptPasswordEncoder();
        }
    }

}
