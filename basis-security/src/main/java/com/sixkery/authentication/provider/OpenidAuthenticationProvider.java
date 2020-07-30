//package com.sixkery.authentication.provider;
//
//import com.blinkframework.security.portal.authentication.UserDetails;
//import com.blinkframework.security.portal.authentication.UserDetailsService;
//import com.blinkframework.security.portal.authentication.token.Authentication;
//import com.blinkframework.security.portal.authentication.token.OpenidAuthenticationToken;
//import com.blinkframework.security.portal.exception.AuthenticationException;
//import com.blinkframework.security.portal.weixin.auth.Code2SessionOutDto;
//import com.blinkframework.security.portal.weixin.auth.WxXcxAuth;
//import com.blinkframework.security.portal.weixin.auth.WxXcxAuthException;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
//import static com.blinkframework.security.portal.response.SecurityResponseStatus.WX_AUTH_ERROR;
//
///**
// * 微信OpenID认证
// *
// * @author maoning
// */
//@Slf4j
//public class OpenidAuthenticationProvider extends AbstractAuthenticationProvider {
//
//    private String appid;
//
//    private String secret;
//
//    private UserDetailsService userDetailsService;
//
//    public void setAppid(String appid) {
//        this.appid = appid;
//    }
//
//    public void setSecret(String secret) {
//        this.secret = secret;
//    }
//
//    public void setUserDetailsService(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected Authentication doAuthenticate(Authentication authentication) throws AuthenticationException {
//        // 获取openid
//        WxXcxAuth wxAuth = new WxXcxAuth();
//        Code2SessionOutDto code2SessionOutDto;
//        try {
//            code2SessionOutDto = wxAuth.code2Session(appid, secret, (String) authentication.principal());
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//            throw new WxXcxAuthException(String.valueOf(WX_AUTH_ERROR.value()), e.getMessage());
//        }
//
//        // 根据openid查询用户信息
//        UserDetails userDetails = userDetailsService.loadByOpenid(code2SessionOutDto.getOpenid());
//
//        // 认证成功
//        OpenidAuthenticationToken auth = new OpenidAuthenticationToken(userDetails);
//        auth.setAuthenticated(true);
//
//        return auth;
//    }
//
//    @Override
//    public boolean support(Class<?> auth) {
//        return OpenidAuthenticationToken.class.isAssignableFrom(auth);
//    }
//}
