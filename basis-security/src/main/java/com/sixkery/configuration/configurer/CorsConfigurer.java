//package com.sixkery.configuration.configurer;
//
//import com.blinkframework.security.portal.authentication.filter.CorsFilter;
//import com.blinkframework.security.portal.configuration.HttpSecurity;
//import com.blinkframework.security.portal.configuration.SecurityConfigurerAdapter;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//import javax.servlet.Filter;
//
//public class CorsConfigurer extends SecurityConfigurerAdapter<Filter, HttpSecurity> {
//
//    private CorsConfigurationSource corsConfigurationSource;
//
//    public CorsConfigurer corsConfigurationSource(CorsConfigurationSource corsConfigurationSource) {
//        this.corsConfigurationSource = corsConfigurationSource;
//        return this;
//    }
//
//    @Override
//    public void configure(HttpSecurity builder) {
//        builder.addFilter(new CorsFilter(corsConfigurationSource));
//    }
//}
