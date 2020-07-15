package com.sixkery.configuration;

import com.blinkframework.security.portal.authentication.AbstractUserDetails;
import com.blinkframework.security.portal.authentication.UserDetails;
import com.blinkframework.security.portal.authentication.UserDetailsService;
import com.blinkframework.security.portal.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.io.Serializable;

/**
 * Create by Maoning in 2019/11/7
 */
@EnableConfigurationProperties(SecurityProperties.class)
public class WebSecurityConfiguration {

    @Autowired(required = false)
    private WebSecurityConfigurer<WebSecurity> securityConfigurer;

    @Bean
    public Filter securityFilterChain(ApplicationContext context, SecurityProperties securityProperties) {
        WebSecurity webSecurity = new WebSecurity();
        if (securityConfigurer == null) {
            WebSecurityConfigurerAdapter webSecurityConfigurerAdapter = new WebSecurityConfigurerAdapter() {};
            webSecurityConfigurerAdapter.setContext(context);
            webSecurityConfigurerAdapter.setSecurityProperties(securityProperties);
            webSecurityConfigurerAdapter.setUserDetailsService(userDetailsService());
            securityConfigurer = webSecurityConfigurerAdapter;
        }
        webSecurity.apply(securityConfigurer);
        return webSecurity.build();
    }

    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public UserDetailsService userDetailsService() {
        return new DefaultUserDetailsService();
    }

    /**
     * ======================================= Default implements ===================================
     */

    class DefaultUserDetailsService implements UserDetailsService {

        @Override
        public UserDetails loadByOpenid(String openid) {
            return null;
        }

        @Override
        public UserDetails loadByUsername(String username) {
            return new AbstractUserDetails() {
                @Override
                public Serializable getId() {
                    return 1;
                }

                @Override
                public String getUsername() {
                    return "admin";
                }

                @Override
                public String getPassword() {
                    return "$2a$10$h2vgFYsXGNnFCCiQIyogZeB8T/ReyG0KY0nr.DifTQD4tVYSDSwi6";
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
        }
    }

}
