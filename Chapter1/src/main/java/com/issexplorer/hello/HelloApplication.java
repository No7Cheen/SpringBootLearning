package com.issexplorer.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        // SpringApplication.run(HelloApplication.class, args);

        Object[] sources = new Object[]{HelloApplication.class};
        SpringApplication springApplication = new SpringApplication(sources);

        // 禁止命令行设置参数
        springApplication.setAddCommandLineProperties(false);

        springApplication.run(args);
    }

}
