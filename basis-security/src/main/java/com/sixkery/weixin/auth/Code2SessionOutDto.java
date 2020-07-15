package com.sixkery.weixin.auth;

import lombok.Data;

/**
 * 写点注释吧，求你了!!!/\^_^/\
 *
 * @author maoning
 */
@Data
public class Code2SessionOutDto {

    private String openid;

    private String session_key;

}
