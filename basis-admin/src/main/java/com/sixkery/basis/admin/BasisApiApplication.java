package com.sixkery.basis.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sixkery
 */
@SpringBootApplication
@MapperScan("com.sixkery.basis.api.mapper")
@ComponentScan(value = "com.sixkery.basis")
@EnableSwagger2
public class BasisApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasisApiApplication.class, args);
    }

}
