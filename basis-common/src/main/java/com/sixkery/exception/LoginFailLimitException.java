package com.sixkery.exception;

import lombok.Data;

/**
 * @author Exrickx
 */
@Data
public class LoginFailLimitException  {

    private String msg;

//    public LoginFailLimitException(String msg) {
//        super(msg);
//        this.msg = msg;
//    }
//
//    public LoginFailLimitException(String msg, Throwable t) {
//        super(msg, t);
//        this.msg = msg;
//    }
}
