//package com.sixkery.configuration;
//
//import com.sixkery.authentication.AuthorizationType;
//import com.sixkery.authentication.UserDetailsService;
//import com.sixkery.configuration.configurer.FilterSecurityInterceptorConfigurer;
//import com.sixkery.properties.AuthorizeProperties;
//import com.sixkery.properties.JwtProperties;
//import com.sixkery.properties.SecurityProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//import javax.servlet.Filter;
//
///**
// * @author sixkery
// */
//public abstract class WebSecurityConfigurerAdapter implements WebSecurityConfigurer<WebSecurity> {
//
//    private ApplicationContext context;
//
//    private boolean disableDefaultConfigure;
//
//    private SecurityProperties securityProperties;
//
//    private UserDetailsService userDetailsService;
//
//    public WebSecurityConfigurerAdapter() {
//        this(false);
//    }
//
//    public WebSecurityConfigurerAdapter(boolean disableDefaultConfigure) {
//        this.disableDefaultConfigure = disableDefaultConfigure;
//    }
//
//    @Override
//    public void init(WebSecurity webSecurity) {
//        HttpSecurity httpSecurity = getHttp();
//        webSecurity.setSecurityBuilder(httpSecurity);
//    }
//
//    @Override
//    public void configure(WebSecurity webSecurity) {
//    }
//
//    /**
//     * 派生类自定义配置
//     *
//     * @param http
//     */
//    protected void configure(HttpSecurity http) {
//    }
//
//    /**
//     * 构建HttpSecurity
//     *
//     * @return
//     */
//    protected HttpSecurity getHttp() {
//        HttpSecurity http = new HttpSecurity();
//        UserDetailsService userDetailsService = userDetailsService();
//
//        // 默认配置
//        if (!disableDefaultConfigure) {
//            JwtProperties jwtProperties = securityProperties().authentication().jwt();
//            CorsConfigurationSource corsConfigSource = this.context.getBean(HandlerMappingIntrospector.class);
//            // 跨域
//            http.cors()
//                    .corsConfigurationSource(corsConfigSource);
//            // 表单登录(用户名+密码认证)
//            http.formLogin()
//                    .jwtProperties(jwtProperties)
//                    .userDetailsService(userDetailsService);
//            // JWT认证
//            http.jwt(jwtProperties)
//                    .userDetailsService(userDetailsService)
//                    .authorizationType(AuthorizationType.BEARER);
//            // openid登录为扩展选项
//        }
//
//        // 调用自定义配置
//        configure(http);
//
//        // 允许子类自定义受保护的资源
//        boolean hasAuthorizeRequests = false;
//        for (SecurityConfigurer<Filter, HttpSecurity> configure : http.getConfigurers()) {
//            if (configure.getClass().isAssignableFrom(FilterSecurityInterceptorConfigurer.class)) {
//                hasAuthorizeRequests = true;
//                break;
//            }
//        }
//        if (!hasAuthorizeRequests) {
//            AuthorizeProperties authorizeProp = securityProperties().authorize();
//            http.authorizeRequests()
//                    .permissions(authorizeProp.getPermissions())
//                    .authenticated(authorizeProp.getAuthenticated());
//        }
//
//        return http;
//    }
//
//    protected UserDetailsService userDetailsService() {
//        return this.userDetailsService;
//    }
//
//    public SecurityProperties securityProperties() {
//        return this.securityProperties;
//    }
//
//    @Autowired
//    public void setContext(ApplicationContext context) {
//        this.context = context;
//    }
//
//    @Autowired
//    public void setSecurityProperties(SecurityProperties securityProperties) {
//        this.securityProperties = securityProperties;
//    }
//
//    @Autowired
//    public void setUserDetailsService(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//}
