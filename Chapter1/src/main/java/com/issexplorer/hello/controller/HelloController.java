package com.issexplorer.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Chapter-1";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!!!";
    }

}
