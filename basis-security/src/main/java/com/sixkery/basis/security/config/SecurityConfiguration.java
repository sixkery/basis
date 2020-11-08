package com.sixkery.basis.security.config;

import com.sixkery.basis.security.filter.JwtAuthenticationFilter;
import com.sixkery.basis.security.filter.JwtAuthorizationFilter;
import com.sixkery.basis.security.service.UserDetailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * security 的配置
 *
 * @author sixkery
 * @date 2020/11/8
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // 开启方法级别的安全控制
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailServiceImpl userDetailService;

    @Resource
    private CacheManager cacheManager;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().
                authorizeRequests().anyRequest().permitAll().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // OPTIONS请求全部放行
                .antMatchers(HttpMethod.POST, "/authentication/**").permitAll()  //登录和注册的接口放行，其他接口全部接受验证
                .antMatchers(HttpMethod.POST).authenticated()
                .antMatchers(HttpMethod.PUT).authenticated()
                .antMatchers(HttpMethod.DELETE).authenticated()
                .antMatchers(HttpMethod.GET).authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), cachingUserDetailsService(userDetailService)))
                // 前后端分离是 STATELESS，故 session 使用该策略
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.headers().cacheControl();

    }

    // 此处配置 AuthenticationManager，并且实现缓存
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 对自己编写的 UserDetailsServiceImpl 进一步包装，实现缓存
        CachingUserDetailsService cachingUserDetailsService = cachingUserDetailsService(userDetailService);
        // jwt-cache 我们在 ehcache.xml 配置文件中有声明
        UserCache userCache = new SpringCacheBasedUserCache(Objects.requireNonNull(cacheManager.getCache("jwt-cache")));
        cachingUserDetailsService.setUserCache(userCache);

//        security 默认鉴权完成后会把密码抹除，但是这里我们使用用户的密码来作为 JWT 的生成密钥，
//        如果被抹除了，在对 JWT 进行签名的时候就拿不到用户密码了，故此处关闭了自动抹除密码。

        auth.eraseCredentials(false);
        auth.userDetailsService(cachingUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    此处我们实现缓存的时候，我们使用了官方现成的 CachingUserDetailsService ，但是这个类的构造方法不是 public 的，
//    我们不能够正常实例化，所以在这里进行曲线救国。

    private org.springframework.security.authentication.CachingUserDetailsService cachingUserDetailsService(UserDetailServiceImpl delegate) {

        Constructor<CachingUserDetailsService> ctor = null;
        try {
            ctor = CachingUserDetailsService.class.getDeclaredConstructor(UserDetailsService.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Assert.notNull(ctor, "CachingUserDetailsService constructor is null");
        ctor.setAccessible(true);
        return BeanUtils.instantiateClass(ctor, delegate);
    }


}
