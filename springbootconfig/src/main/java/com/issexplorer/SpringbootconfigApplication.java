package com.issexplorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootconfigApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringbootconfigApplication.class, args);

        Object[] sources = new Object[]{SpringbootconfigApplication.class};
        SpringApplication springApplication = new SpringApplication(sources);

        // 禁止命令行设置参数
        springApplication.setAddCommandLineProperties(false);

        springApplication.run(args);
    }
}
