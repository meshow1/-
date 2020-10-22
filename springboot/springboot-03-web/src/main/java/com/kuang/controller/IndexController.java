package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.Arrays;
//
////template下所有页面只能通过controller访问
////需要模板引擎的支持，需要导入 thymeleaf 依赖
//@Controller
//public class IndexController {
//
//    @GetMapping("/test")
//    public String index(Model model){
//        model.addAttribute("msg","<h1>hello,sb</h1>");
//        model.addAttribute("users", Arrays.asList("qinjiang","姜"));
//        return "test";
//    }
//}