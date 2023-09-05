package com.sixkery.basis.es.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author sixkery
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "service.es")
public class EsProperties {

    /**
     * host
     */
    private String host;

    /**
     * port
     */
    private Integer port;

    private String username;

    private String password;


}
