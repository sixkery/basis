package com.sixkery.authentication.filter;

import com.sixkery.api.BasicResponseStatus;
import com.sixkery.api.ResponseModels;
import com.sixkery.authentication.AuthorizationType;
import com.sixkery.authentication.token.Authentication;
import com.sixkery.authentication.token.JwtAuthenticationToken;
import com.sixkery.exception.AuthenticationException;
import com.sixkery.exception.JwtAuthenticationException;
import com.sixkery.response.SecurityResponseStatus;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sixkery
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private AuthorizationType authorizationType;

    private static String AUTHORIZATION = "Authorization";

    @Override
    protected boolean requires(HttpServletRequest request) {
        String authorization = request.getHeader(AUTHORIZATION);
        return StringUtils.hasText(authorization) && authorization.startsWith(authorizationType.prefix());
    }

    @Override
    protected Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String authorization = request.getHeader(AUTHORIZATION);
        String authorizationWithoutPrefix = authorization.replace(authorizationType.prefix(), "");

        JwtAuthenticationToken token = new JwtAuthenticationToken(authorizationWithoutPrefix);

        return authenticationManager().authenticate(token);
    }

    public void setAuthorizationType(AuthorizationType authorizationType) {
        this.authorizationType = authorizationType;
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletResponse response, AuthenticationException ae)
            throws IOException {
        if (ae instanceof JwtAuthenticationException) {
            JwtException je = ((JwtAuthenticationException) ae).getException();
            if (je instanceof MalformedJwtException) {
                ResponseModels.print(response, SecurityResponseStatus.MALFORMED_JWT);
            } else if (je instanceof UnsupportedJwtException) {
                ResponseModels.print(response, SecurityResponseStatus.UNSUPPORTED_JWT);
            } else if (je instanceof SignatureException) {
                ResponseModels.print(response, SecurityResponseStatus.JWT_SIGNATURE_ERROR);
            } else if (je instanceof ExpiredJwtException) {
                ResponseModels.print(response, SecurityResponseStatus.EXPIRED_JWT);
            } else {
                logger.error(ae);
                ResponseModels.print(response, BasicResponseStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            logger.error(ae);
            ResponseModels.print(response, BasicResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
