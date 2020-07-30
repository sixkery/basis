//package com.sixkery.configuration.configurer;
//
//import com.blinkframework.security.portal.authentication.AuthenticationManager;
//import com.blinkframework.security.portal.authentication.AuthorizationType;
//import com.blinkframework.security.portal.authentication.UserDetailsService;
//import com.blinkframework.security.portal.authentication.filter.JwtAuthenticationFilter;
//import com.blinkframework.security.portal.authentication.provider.JwtAuthenticationProvider;
//import com.blinkframework.security.portal.configuration.HttpSecurity;
//import com.blinkframework.security.portal.configuration.SecurityConfigurerAdapter;
//import com.blinkframework.security.portal.properties.JwtProperties;
//
//import javax.servlet.Filter;
//
//public class JwtAuthenticationConfigurer extends SecurityConfigurerAdapter<Filter, HttpSecurity> {
//
//    private JwtProperties jwtProperties;
//
//    private UserDetailsService userDetailsService;
//
//    private AuthorizationType authorizationType = AuthorizationType.BEARER;
//
//    public JwtAuthenticationConfigurer(JwtProperties properties) {
//        this.jwtProperties = properties;
//    }
//
//    public JwtAuthenticationConfigurer authorizationType(AuthorizationType authorizationType) {
//        this.authorizationType = authorizationType;
//        return this;
//    }
//
//    public JwtAuthenticationConfigurer userDetailsService(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//        return this;
//    }
//
//
//    @Override
//    public void configure(HttpSecurity builder) {
//        AuthenticationManager authenticationManager = builder.authenticationManager();
//
//        // JWT 认证提供者
//        JwtAuthenticationProvider provider = new JwtAuthenticationProvider();
//        provider.setJwtProperties(jwtProperties);
//        provider.setUserDetailsService(userDetailsService);
//
//        // 向认证管理器注册认证提供者
//        authenticationManager.registerProvider(provider);
//
//        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
//
//        filter.setAuthorizationType(authorizationType);
//        filter.setAuthenticationManager(authenticationManager);
//
//        builder.addFilter(filter);
//    }
//
//}
