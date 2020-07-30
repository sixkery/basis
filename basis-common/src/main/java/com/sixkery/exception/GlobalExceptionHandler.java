package com.sixkery.exception;

import com.sixkery.common.ApiResponse;
import com.sixkery.common.ApiResponses;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sixkery
 * @date 2020/4/23
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ApiResponse<Object> handle(ApiException e) {

        if (e.getErrorCode() != null) {
            return ApiResponses.failed(e.getErrorCode());
        } else {
            return ApiResponses.failed(e.getMessage());
        }
    }

}
