package com.sixkery.basis.es.config;

import com.sixkery.basis.es.config.properties.IgnoreUrlProperties;
import com.sixkery.basis.es.config.properties.TokenProperties;
import com.sixkery.basis.es.filter.JwtAuthenticationTokenFilter;
import com.sixkery.basis.es.filter.RestAccessDeniedHandler;
import com.sixkery.basis.es.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * security 核心配置类
 * 开启注解控制权到 controller
 *
 * @author sixkery
 * @date 2020/11/8
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Resource
    private TokenProperties tokenProperties;


    @Resource
    private IgnoreUrlProperties ignoreUrlProperties;


    @Resource
    private UserDetailServiceImpl userDetailService;


    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    //自定义无权限访问拦截器
    @Resource
    private RestAccessDeniedHandler restAccessDeniedHandler;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 前后端分离是 STATELESS，故 session 使用该策略
                .and().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // OPTIONS请求全部放行
                .antMatchers("/auth/**").permitAll()  //登录和注册的接口放行，其他接口全部接受验证.antMatchers("/druid/**").anonymous()
                .anyRequest().authenticated()
                .and().headers().cacheControl();

        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.exceptionHandling().accessDeniedHandler(restAccessDeniedHandler);
    }

    // 此处配置 AuthenticationManager，并且实现缓存
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
