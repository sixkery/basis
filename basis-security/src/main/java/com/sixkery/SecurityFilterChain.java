package com.sixkery;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author sixkery
 */
public class SecurityFilterChain extends GenericFilterBean {

    private List<Filter> filters;

    public SecurityFilterChain(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        SecurityFilterChainProxy chainProxy = new SecurityFilterChainProxy(chain);
        chainProxy.doFilter(request, response);
    }

    class SecurityFilterChainProxy implements FilterChain {

        private int currentPosition;

        private FilterChain originalChain;

        public SecurityFilterChainProxy(FilterChain chain) {
            this.originalChain = chain;
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response)
                throws IOException, ServletException {
            if (currentPosition == filters.size()) {
                originalChain.doFilter(request, response);
                return;
            }

            currentPosition++;
            Filter nextFilter = filters.get(currentPosition - 1);

            nextFilter.doFilter(request, response, this);
        }
    }

}
