package com.kuang.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        //设置业务逻辑
        String result = "HelloMVC";

        mv.addObject("msg",result);
        mv.setViewName("hello");//会通过视图解析器添加首位

        return mv;
    }
}
