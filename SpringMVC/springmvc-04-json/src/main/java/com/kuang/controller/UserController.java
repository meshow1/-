package com.kuang.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController//功能和ResponseBody一样，但是作用于类
// @RestController，一般是使用在类上的，它表示的意思其实就是结合了@Controller和@ResponseBody两个注解，
//@Controller
public class UserController {

//    @RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")可以通过这种方式更改json编码格式,
//    也可以再springmvc配置文件中进行配置
    @RequestMapping("/j1")
    @ResponseBody //不会走视图解析器,会返回字符串
    public String json1() throws JsonProcessingException {

        User user = new User(new String("姜"),1,"male");

        //通过jackson包将对象转为String
        ObjectMapper mapper = new ObjectMapper();
        //java转json和json转java分别为 mapper.readValue( jsondata, java类)
        //和   writeValueAsString（）
        String str = mapper.writeValueAsString(user);



        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<User> users = new ArrayList<>();

        User u1 = new User("1", 1, "是");
        User u2 = new User("1", 1, "是");
        User u3 = new User("1", 1, "是");
        User u4 = new User("1", 1, "是");

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);


        String str = mapper.writeValueAsString(users);

        return str;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();

        String str = mapper.writeValueAsString(date);

        return JsonUtils.getJson(date, "y-m-d h:m:s");
    }
}
