package com.sixkery.basis.security.util.constant;

import cn.hutool.core.util.IdUtil;

/**
 * @author sixkery
 */
public class SecurityConstant {
    /**
     * token分割
     */
    public static final String TOKEN_SPLIT = "Bearer ";

    /**
     * JWT签名加密key
     */
    public static final String JWT_SIGN_KEY = IdUtil.simpleUUID();

    /**
     * token参数头
     */
    public static final String HEADER = "accessToken";

    /**
     * 权限参数头
     */
    public static final String AUTHORITIES = "authorities";

    /**
     * 用户选择JWT保存时间参数头
     */
    public static final String SAVE_LOGIN = "saveLogin";

    /**
     * 交互 token前缀 key
     */
    public static final String TOKEN_PRE = "TOKEN_PRE:";

    /**
     * 用户 token前缀 key 单点登录使用
     */
    public static final String USER_TOKEN = "USER_TOKEN:";
}
