package com.sixkery.common.exception;

import com.sixkery.common.response.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 *
 * @author sixkery
 * @date 2020/4/23
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 系统内部错误捕获的异常
     *
     * @param e 异常
     * @return ApiResponses
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponses uniteExceptionHandler(Exception e) {
        log.error("系统异常", e);
        return ApiResponses.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ApiResponses<Object> handle(ApiException e) {

        if (e.getErrorCode() != null) {
            return ApiResponses.failed(e.getErrorCode(), e.getMessage());
        } else {
            return ApiResponses.failed(e.getMessage());
        }
    }

}