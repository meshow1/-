package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //这个类中所有方法若返回值是String，并被RequestMapping注解标注就会被视图器解析
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test1(Model model){
        model.addAttribute("msg", "ControllerTest2");

        return "test";
    }
}
