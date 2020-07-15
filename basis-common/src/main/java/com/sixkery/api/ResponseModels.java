package com.sixkery.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixkery.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对ResponseModel快捷封装,通用返回对象
 *
 * @author sixkery
 * @date 2019/4/19
 */
public class ResponseModels<T> {

    private ResponseModels() {
    }


    public static <T> ResponseModel<T> ok() {
        return ok((T) null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseModel<T> ok(T data) {
        return new ResponseModel<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ResponseModel<T> success(T data, String message) {
        return new ResponseModel<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ResponseModel<T> failed(ErrorCode errorCode) {
        return new ResponseModel<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> ResponseModel<T> failed(ErrorCode errorCode, String message) {
        return new ResponseModel<>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResponseModel<T> failed(String message) {
        return new ResponseModel<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseModel<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResponseModel<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResponseModel<T> validateFailed(String message) {
        return new ResponseModel<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResponseModel<T> unauthorized(T data) {
        return new ResponseModel<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResponseModel<T> forbidden(T data) {
        return new ResponseModel<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public static void print(HttpServletResponse response, ResponseStatus status) throws IOException {
        print(response, status, null);
    }

    public static <T> void print(HttpServletResponse response, ResponseStatus status, T data) throws IOException {
        print(response, new ResponseModel<>(status, data));
    }


    public static void print(HttpServletResponse response, ResponseModel model) throws IOException {
        // 如果ResponseStatus的值小于等于1000且不等于200，那么就算是失败的请求，这里设置对应的响应状态
        int rsCode = model.getCode();
        if (rsCode < 1000 && rsCode != 200) {
            response.setStatus(rsCode);
        }
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "application/json");
        new ObjectMapper().writer().writeValue(response.getOutputStream(), model);
    }

}
