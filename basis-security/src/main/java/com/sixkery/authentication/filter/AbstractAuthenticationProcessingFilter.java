package com.sixkery.authentication.filter;

import com.sixkery.common.ResponseModels;
import com.sixkery.authentication.AuthenticationManager;
import com.sixkery.authentication.token.Authentication;
import com.sixkery.exception.AuthenticationException;
import com.sixkery.exception.UserDisabledException;
import com.sixkery.exception.UserNotFoundException;
import com.sixkery.response.SecurityResponseStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sixkery
 */
public abstract class AbstractAuthenticationProcessingFilter extends GenericFilterBean {

    private AuthenticationManager authenticationManager;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (!requires(request)) {
            chain.doFilter(request, response);
            return;
        }

        // 认证
        Authentication authentication;

        try {
            authentication = attemptAuthentication(request, response);
            if (authentication == null) {
                return;
            }
        } catch (AuthenticationException ae) {
            if (ae instanceof UserNotFoundException) {
                ResponseModels.print(response, SecurityResponseStatus.USERNAME_NOTFOUND);
            } else if (ae instanceof UserDisabledException) {
                ResponseModels.print(response, SecurityResponseStatus.ACCOUNT_DISABLED);
            } else {
                unsuccessfulAuthentication(response, ae);
            }
            return;
        }

        successfulAuthentication(request, response, authentication);

        if (response.isCommitted()) {
            return;
        }

        chain.doFilter(request, response);
    }

    public AuthenticationManager authenticationManager() {
        return this.authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    protected abstract boolean requires(HttpServletRequest request);

    protected abstract Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException;

    protected abstract void unsuccessfulAuthentication(HttpServletResponse response, AuthenticationException ae)
            throws IOException;

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
