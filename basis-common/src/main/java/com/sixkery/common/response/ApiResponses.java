package com.sixkery.common.response;


import lombok.Data;

/**
 * 对 ApiResponses 快捷封装,通用返回对象
 *
 * @author sixkery
 * @date 2019/4/19
 */
@Data
public class ApiResponses<T> {

    private int code;

    private String message;

    private T data;

    private long timestamp;

    public ApiResponses(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ApiResponses() {
    }


    public static <T> ApiResponses<T> ok() {
        return ok(null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ApiResponses<T> ok(T data) {
        return new ApiResponses<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ApiResponses<T> success(T data, String message) {
        return new ApiResponses<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ApiResponses<T> failed(ErrorCode errorCode) {
        return new ApiResponses<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> ApiResponses<T> failed(ErrorCode errorCode, String message) {
        return new ApiResponses<>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public static <T> ApiResponses<T> failed(Integer code, String message) {
        return new ApiResponses<>(code, message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ApiResponses<T> failed(String message) {
        return new ApiResponses<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ApiResponses<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ApiResponses<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ApiResponses<T> validateFailed(String message) {
        return new ApiResponses<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ApiResponses<T> unauthorized(T data) {
        return new ApiResponses<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ApiResponses<T> forbidden(T data) {
        return new ApiResponses<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }


//
//    public static void print(HttpServletResponse response, ApiResponses model) throws IOException {
//        // 如果ResponseStatus的值小于等于1000且不等于200，那么就算是失败的请求，这里设置对应的响应状态
//        int rsCode = model.getCode();
//        if (rsCode < 1000 && rsCode != 200) {
//            response.setStatus(rsCode);
//        }
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "application/json");
//        new ObjectMapper().writer().writeValue(response.getOutputStream(), model);
//    }

}
