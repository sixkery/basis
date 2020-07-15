package com.sixkery.util;

import com.blinkframework.security.portal.SecurityContextHolder;
import com.blinkframework.security.portal.authentication.UserDetails;
import com.blinkframework.security.portal.authentication.token.Authentication;

import java.io.Serializable;

/**
 * 安全上下文工具类
 * <h3>工具类定义规范(二选一，根据具体业务场景而定)：</h3>
 * <ul>
 *     <li>类对外提供单一实例，类的所有方法都是成员方法</li>
 *     <li>构造函数私有化，不对外提供实例，所有方法声明为静态方法</li>
 * </ul>
 */
public class SecurityContextUtils {

    private SecurityContextUtils() {
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().principal();
    }

    public static Serializable getUserId() {
        return getUserDetails().getId();
    }

    public static String getUsername() {
        return getUserDetails().getUsername();
    }

}
