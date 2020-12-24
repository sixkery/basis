package com.sixkery.basis.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sixkery
 */
@MapperScan("com.sixkery.mapper")
@SpringBootApplication
public class BasisSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasisSecurityApplication.class, args);
    }

}
