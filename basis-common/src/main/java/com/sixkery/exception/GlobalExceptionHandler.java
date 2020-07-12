package com.sixkery.exception;

import com.sixkery.api.ResponseModel;
import com.sixkery.api.ResponseModels;
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
    public ResponseModel<Object> handle(ApiException e) {

        if (e.getErrorCode() != null) {
            return ResponseModels.failed(e.getErrorCode());
        } else {
            return ResponseModels.failed(e.getMessage());
        }
    }

}
