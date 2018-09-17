package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Cay
 * @Date: 2018/9/15 15:46
 * @Description:
 */

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index(){
        return "Hello Spring Boot!";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
