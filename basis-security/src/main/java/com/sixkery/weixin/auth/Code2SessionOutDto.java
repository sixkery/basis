package com.sixkery.weixin.auth;

import lombok.Data;

/**
 *
 * @author sixkery
 */
@Data
public class Code2SessionOutDto {

    /**
     * 微信 openID
     */
    private String openid;

    /**
     * 微信 session_key
     */
    private String session_key;

}
