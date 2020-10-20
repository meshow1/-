package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {

    @RequestMapping("/m1/t1")//依旧可以使用req， resp
    public String test(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        System.out.println(session.getId());

//        return "/WEB-INF/jsp/test.jsp";//默认是相当于转发
        return "redirect:/index.jsp";//重定向
    }
}
