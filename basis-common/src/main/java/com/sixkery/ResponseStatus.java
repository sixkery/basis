package com.sixkery;

/**
 * 创建枚举类并实现此接口使其成为一个标准的响应状态类
 *
 * <p>除BasicResponseStatus中包含的基本HTTP响应状态之外，从1001开始分配, 建议每类业务预留至少20个状态码.</p>
 *
 * Example:
 * <pre>
 *     public enum SecurityResponseStatus implements ResponseStatus {
 *
 *     //------------------------------- UsernamePassword Authentication Exception ---------------------------------//
 *
 *     USERNAME_NOTFOUND(1001, "用户名不存在"),
 *
 *     BAD_CREDENTIALS(1002, "密码错误"),
 *
 *     ACCOUNT_LOCKED(1003, "用户被锁定"),
 *
 *     ACCOUNT_DISABLED(1004, "用户被禁用"),
 *
 *     ACCOUNT_EXPIRED(1005, "账号过期"),
 *
 *     //------------------------------- JWT Authentication Exception ---------------------------------//
 *
 *     MALFORMED_JWT(1020, "token格式错误"),
 *
 *     EXPIRED_JWT(1021, "token过期"),
 *
 *     UNSUPPORTED_JWT(1022, "不支持的token"),
 *
 *     JWT_SIGNATURE_ERROR(1023, "token签名错误");
 *
 *     private final int value;
 *
 *     private final String reasonPhrase;
 *
 *     SecurityResponseStatus(int value, String reasonPhrase) {
 *         this.value = value;
 *         this.reasonPhrase = reasonPhrase;
 *     }
 *
 *     @Override
 *     public int value() {
 *         return this.value;
 *     }
 *
 *     @Override
 *     public String reasonPhrase() {
 *         return this.reasonPhrase;
 *     }
 * }
 * </pre>
 *
 * Create by Maoning in 2019/10/10
 */
public interface ResponseStatus {

    int value();

    String reasonPhrase();

}
