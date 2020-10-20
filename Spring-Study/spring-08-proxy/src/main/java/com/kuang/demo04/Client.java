package com.kuang.demo04;

import com.kuang.demo02.UserSerive;
import com.kuang.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService=new UserServiceImpl();

        //代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        //代理真实
        pih.setTarget(userService);

        //生成代理类
        UserSerive proxy = (UserSerive) pih.getProxy();

        //使用
        proxy.add();



    }
}
