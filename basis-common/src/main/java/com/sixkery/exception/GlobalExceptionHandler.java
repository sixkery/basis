package com.sixkery.exception;

import com.sixkery.api.ResponseResult;
import com.sixkery.api.ResponseResults;
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
    public ResponseResult<Object> handle(ApiException e) {

        if (e.getErrorCode() != null) {
            return ResponseResults.failed(e.getErrorCode());
        } else {
            return com.sixkery.api.ResponseResults.failed(e.getMessage());
        }
    }

}
