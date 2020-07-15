package com.sixkery.properties;

import lombok.Data;

import java.util.UUID;

/**
 * @author sixkery
 */
@Data
public class JwtProperties {

    /**
     * 有效时间，单位：秒(s)
     */
    private int expire = 7200;

    /**
     * 签发者
     */
    private String issuer = "BLink";

    /**
     * 如果不配置JWT秘钥，系统将使用随机UUID作为秘钥，每次服务重启都会重新生成新的秘钥
     */
    private String secretKey = UUID.randomUUID().toString();

}
