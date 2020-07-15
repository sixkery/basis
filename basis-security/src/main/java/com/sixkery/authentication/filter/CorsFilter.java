package com.sixkery.authentication.filter;

import org.springframework.web.cors.*;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sixkery
 */
public class CorsFilter extends OncePerRequestFilter {

    private CorsConfigurationSource configSource;

    private CorsProcessor processor = new DefaultCorsProcessor();

    public CorsFilter(CorsConfigurationSource configSource) {
        this.configSource = configSource;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (CorsUtils.isCorsRequest(request)) {
            CorsConfiguration corsConfiguration = this.configSource.getCorsConfiguration(request);
            if (corsConfiguration != null) {
                boolean isValid = this.processor.processRequest(corsConfiguration, request, response);
                if (!isValid || CorsUtils.isPreFlightRequest(request)) {
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
    }

}
