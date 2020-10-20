package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//也是component的别名，实质也是一个bean
public class ControllerTest3 {
    @RequestMapping("/t3")
    public String test1(Model model){
        model.addAttribute("msg","test3");
        return "test";
    }
//
//    @RequestMapping
//    @GetMapping
//    @DeleteMapping
//    ....是规定了请求类型的RequestMapping，只能处理规定的类型的请求

    //正常风格,地址栏url应该为 localhost/t3?a=1&b=2
//    @GetMapping("/t3")
//    public String test2(int a,int b,Model model)


    //restful风格,可以通过请求不同将同一个url调用不同的方法，比如再写一个PostMapping定义到同一个url
    @GetMapping("/t4/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        int c=a+b;
        model.addAttribute("msg",""+c);
        return "test";
    }
}
