package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//通过注解一个控制器类可以创建多个控制器
@Controller
@RequestMapping("/HelloController")
public class HelloController {

    @RequestMapping("/hello")//最后访问的是/HelloController/hello
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg", "HellomAnnotation");

        return "hello";//会被视图解析器处理,跳转到..../hello.jsp
    }
}
