package com.sixkery.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sixkery
 * @date 2020/5/17
 * <p>
 * 配置不需要保护的资源路径
 */
@Data
@ConfigurationProperties(prefix = "security.ignore")
public class IgnoreUrlConfig {

    private List<String> urls = new ArrayList<>();
}
