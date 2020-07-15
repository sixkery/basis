package com.sixkery.authentication.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixkery.api.ResponseModels;
import com.sixkery.authentication.JwtFactory;
import com.sixkery.authentication.UserDetails;
import com.sixkery.authentication.token.Authentication;
import com.sixkery.authentication.token.UsernamePasswordAuthenticationToken;
import com.sixkery.exception.AuthenticationException;
import com.sixkery.exception.BadCredentialsException;
import com.sixkery.properties.JwtProperties;
import com.sixkery.response.SecurityResponseStatus;
import com.sixkery.util.AntPathRequestMatcher;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Create by Maoning in 2019/11/6
 */
@Component
public class UsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private JwtProperties jwtProperties;

    private static final String DEFAULT_USERNAME_PARAMETER = "username";

    private static final String DEFAULT_PASSWORD_PARAMETER = "password";

    public void setJwtProperties(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Override
    protected boolean requires(HttpServletRequest request) {
        String loginProcessUrl = "/auth/pwd";
        return new AntPathRequestMatcher(loginProcessUrl, HttpMethod.POST.name()).matches(request);
    }

    @Override
    protected Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {
        // Read parameters from JSON
        Map<String, String> parameters = new ObjectMapper().readValue(request.getInputStream(),
                new TypeReference<Map<String, String>>() {});

        String username = parameters.get(DEFAULT_USERNAME_PARAMETER);
        String password = parameters.get(DEFAULT_PASSWORD_PARAMETER);

        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager().authenticate(token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletResponse response, AuthenticationException ae)
            throws IOException {
        if (ae instanceof BadCredentialsException) {
            ResponseModels.print(response, SecurityResponseStatus.BAD_CREDENTIALS);
        } else {
            logger.error(ae);
            ResponseModels.print(response, BasicResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        UserDetails userDetails = (UserDetails) authentication.principal();
        // Generate JWT
        String token = JwtFactory.newInstance(jwtProperties).create(userDetails.getUsername());
        ResponseModels.print(response, BasicResponseStatus.OK, token);
    }
}
