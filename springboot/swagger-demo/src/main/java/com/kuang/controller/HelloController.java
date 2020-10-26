package com.kuang.controller;

import com.kuang.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiOperation("hello控制类")//给方法加注释
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }
}
