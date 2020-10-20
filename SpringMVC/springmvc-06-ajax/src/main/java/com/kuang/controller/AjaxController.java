package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//AJAX 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术


@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("狂神说",1,"男"));
        userList.add(new User("姜",2,"男"));
        return userList;
    }

}
