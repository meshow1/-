package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    //========================================使用JDBC========================================================
    //拿到jdbctemplateconfiguration中配好的bean
    @Autowired
    JdbcTemplate jdbcTemplate;

    //尝试用sql查询数据库所有信息
    //不知道实体类，数据库中东西怎么获取？ 用mao获取即可
    @GetMapping("/userList")
    public List<Map<String, Object>> userList(){
        String ql="select * from student";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(ql);
        return maps;
    }
    @GetMapping("/addUser")
    public String addUser(){
        String sql="insert into user (id,name,pwd) values (4,'小明','12345')";
        int update = jdbcTemplate.update(sql);
        return "update";
    }
}
