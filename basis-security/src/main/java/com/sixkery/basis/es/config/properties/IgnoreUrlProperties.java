package com.sixkery.basis.es.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置忽略的 url
 * @author sixkery
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "basis.ignore")
public class IgnoreUrlProperties {

    /**
     * 忽略的 url
     */
    private List<String> urls = new ArrayList<>();

    /**
     * 限流及黑名单不拦截的路径
     */
    private List<String> limitUrls = new ArrayList<>();


}
