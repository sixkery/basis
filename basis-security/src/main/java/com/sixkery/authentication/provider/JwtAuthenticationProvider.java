//package com.sixkery.authentication.provider;
//
//import com.blinkframework.security.portal.authentication.UserDetails;
//import com.blinkframework.security.portal.authentication.UserDetailsService;
//import com.blinkframework.security.portal.authentication.token.Authentication;
//import com.blinkframework.security.portal.authentication.token.JwtAuthenticationToken;
//import com.blinkframework.security.portal.exception.AuthenticationException;
//import com.blinkframework.security.portal.exception.JwtAuthenticationException;
//import com.blinkframework.security.portal.properties.JwtProperties;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwt;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//
//import java.util.Base64;
//
///**
// * JWT认证
// * Create by Maoning in 2019/11/7
// */
//public class JwtAuthenticationProvider extends AbstractAuthenticationProvider {
//
//    private JwtProperties jwtProperties;
//
//    private UserDetailsService userDetailsService;
//
//    public void setJwtProperties(JwtProperties jwtProperties) {
//        this.jwtProperties = jwtProperties;
//    }
//
//    public void setUserDetailsService(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected Authentication doAuthenticate(Authentication authentication) throws AuthenticationException {
//
//        // Get token form request.
//        String username = this.decodeJwt((String) authentication.principal());
//
//        // Load UserDetails
//        UserDetails userDetails = userDetailsService.loadByUsername(username);
//
//        JwtAuthenticationToken result = new JwtAuthenticationToken(userDetails);
//        result.setAuthenticated(true);
//
//        return result;
//    }
//
//    @Override
//    public boolean support(Class<?> auth) {
//        return JwtAuthenticationToken.class.isAssignableFrom(auth);
//    }
//
//    /**
//     * 解析JWT
//     * @param token
//     * @return
//     * @throws JwtAuthenticationException
//     */
//    private String decodeJwt(String token) throws JwtAuthenticationException {
//        Jwt jwt;
//        String signKey = Base64.getEncoder().encodeToString(jwtProperties.getSecretKey().getBytes());
//
//        try {
//            jwt = Jwts.parser().setSigningKey(signKey).parse(token);
//        } catch (JwtException e) {
//            throw new JwtAuthenticationException(e);
//        }
//
//        Claims claims = (Claims) jwt.getBody();
//
//        return (String) claims.get("username");
//    }
//}
