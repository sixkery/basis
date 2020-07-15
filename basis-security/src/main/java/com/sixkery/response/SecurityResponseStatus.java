package com.sixkery.response;


import com.sixkery.ResponseStatus;

/**
 * @author sixkery
 */
public enum SecurityResponseStatus implements ResponseStatus {

    //------------------------------- UsernamePassword Authentication Exception ---------------------------------//

    USERNAME_NOTFOUND(1001, "用户不存在"),

    BAD_CREDENTIALS(1002, "密码错误"),

    ACCOUNT_LOCKED(1003, "用户被锁定"),

    ACCOUNT_DISABLED(1004, "用户被禁用"),

    ACCOUNT_EXPIRED(1005, "账号过期"),

    //------------------------------- JWT Authentication Exception ---------------------------------//

    MALFORMED_JWT(1020, "token格式错误"),

    EXPIRED_JWT(1021, "token过期"),

    UNSUPPORTED_JWT(1022, "不支持的token"),

    JWT_SIGNATURE_ERROR(1023, "token签名错误"),


    //------------------------------- Openid Authentication Exception ---------------------------------//

    WX_AUTH_ERROR(1030, "微信认证异常")
    ;

    private final int value;

    private final String reasonPhrase;

    SecurityResponseStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    @Override
    public int value() {
        return this.value;
    }

    @Override
    public String reasonPhrase() {
        return this.reasonPhrase;
    }
}
