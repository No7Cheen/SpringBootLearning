package com.issexplorer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController 注解等价于 @Controller + @ResponseBody 的结合，使用这个注解的类里面的方法都以 json 格式输出
 */
@RestController
public class HelloController {

    /**
     * 访问：http://127.0.0.1:8080/hello
     *
     * @return 打印 Hello World
     */
    @RequestMapping("/")
    public String index() {
        return "Hello... Hello World！！！";
    }

}
