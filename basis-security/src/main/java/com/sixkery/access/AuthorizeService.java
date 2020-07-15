package com.sixkery.access;


import com.sixkery.authentication.token.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface AuthorizeService {

    boolean hasPermission(Authentication authentication, HttpServletRequest request);

}
