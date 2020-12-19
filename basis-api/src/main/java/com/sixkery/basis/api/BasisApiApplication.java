package com.sixkery.basis.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sixkery
 */
@SpringBootApplication
@MapperScan("com.sixkery.basis.api.mapper")
@EnableSwagger2
public class BasisApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasisApiApplication.class, args);
    }

}
