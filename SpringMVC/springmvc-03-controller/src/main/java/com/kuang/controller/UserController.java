package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){//可以再RequestParam中定义传递对象的名字
        //接收前端参数
        System.out.println("接收前端参数为"+name);
        //返回结果给前端
        model.addAttribute("msg", name);
        //跳转视图
        return "test";
    }

    @GetMapping("/t2")//也可以传递对象，可以自动匹配对象中的字段名
    public String test2(User user){
        System.out.println(user);
        //跳转视图
        return "test";
    }

    @RequestMapping("/t3")
    public String test3(String name, Model model, HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");//处理post请求编码问题,get请求参数在url上不涉及编解码

        System.out.println(name);
        model.addAttribute("msg", name);
        return "test";
    }

}
