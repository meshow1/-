package com.kuang.consumer_server.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service//放到spring容器
public class UserService {
    //去注册中心拿到需要的服务
    @Reference//引用，  公司中使用Pom坐标
            //也可以在同目录下的同名接口注入容器进行远程调用
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println(ticket);
    }

}
