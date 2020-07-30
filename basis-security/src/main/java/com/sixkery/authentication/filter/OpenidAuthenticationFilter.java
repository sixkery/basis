//package com.sixkery.authentication.filter;
//
//
//import com.sixkery.common.ResponseResults;
//import com.sixkery.authentication.JwtFactory;
//import com.sixkery.authentication.UserDetails;
//import com.sixkery.authentication.token.Authentication;
//import com.sixkery.authentication.token.OpenidAuthenticationToken;
//import com.sixkery.exception.AuthenticationException;
//import com.sixkery.properties.JwtProperties;
//import com.sixkery.response.SecurityResponseStatus;
//import com.sixkery.util.AntPathRequestMatcher;
//import com.sixkery.weixin.auth.WxXcxAuthException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 微信OpenID登录
// */
//public class OpenidAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    private JwtProperties jwtProperties;
//
//    /**
//     * 微信登录请求地址
//     */
//    private AntPathRequestMatcher requestMatcher = new AntPathRequestMatcher("/auth/wx");
//
//    public OpenidAuthenticationFilter(JwtProperties properties) {
//        this.jwtProperties = properties;
//    }
//
//    @Override
//    protected boolean requires(HttpServletRequest request) {
//        return requestMatcher.matches(request);
//    }
//
//    @Override
//    protected Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//            throws AuthenticationException {
//        String code = request.getParameter("code");
//        return authenticationManager().authenticate(new OpenidAuthenticationToken(code));
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletResponse response, AuthenticationException ae)
//            throws IOException {
//        if (ae instanceof WxXcxAuthException) {
//            WxXcxAuthException we = (WxXcxAuthException) ae;
//            Map<String, String> data = new HashMap<>();
//            data.put("errmsg", we.getErrmsg());
//            data.put("errcode", we.getErrcode());
//            ResponseResults.print(response, SecurityResponseStatus.WX_AUTH_ERROR, data);
//        } else {
//            logger.error(ae);
//            ResponseResults.print(response, BasicResponseStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//            throws IOException {
//        UserDetails userDetails = (UserDetails) authentication.principal();
//        String token = JwtFactory.newInstance(jwtProperties).create(userDetails.getUsername());
//        ResponseResults.print(response, BasicResponseStatus.OK, token);
//    }
//}
