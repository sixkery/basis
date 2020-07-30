//package com.sixkery.authentication;
//
//import com.blinkframework.security.portal.authentication.provider.AuthenticationProvider;
//import com.blinkframework.security.portal.authentication.token.Authentication;
//import com.blinkframework.security.portal.exception.AuthenticationException;
//import com.blinkframework.security.portal.exception.ProviderNotFoundException;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * Create by Maoning in 2019/11/7
// */
//public class AuthenticationManagerImpl implements AuthenticationManager {
//
//    private List<AuthenticationProvider> providers;
//
//    public AuthenticationManagerImpl() {
//        this(Collections.emptyList());
//    }
//
//    public AuthenticationManagerImpl(List<AuthenticationProvider> providers) {
//        this.providers = new ArrayList<>(providers);
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        Authentication authResult = null;
//
//        for (AuthenticationProvider provider : providers) {
//            if (!provider.support(authentication.getClass())) {
//                continue;
//            }
//            authResult = provider.authenticate(authentication);
//        }
//
//        if (authResult == null) {
//            throw new ProviderNotFoundException();
//        }
//
//        return authResult;
//    }
//
//    public void registerProvider(AuthenticationProvider provider) {
//        this.providers.add(provider);
//    }
//
//}
