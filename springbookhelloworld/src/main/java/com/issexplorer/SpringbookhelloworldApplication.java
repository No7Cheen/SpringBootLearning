package com.issexplorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication 注解是 Spring Boot 项目的核心注解，主要目的是开启自动配置
 */
@SpringBootApplication
public class SpringbookhelloworldApplication {

    /**
     * 个标准 Java 应用的 main 方法，作为项目启动的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbookhelloworldApplication.class, args);
    }

}
