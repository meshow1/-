package com.kuang.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service//可以被dubbo扫描到注册到注册中心
@Component//使用dubbo后尽量不要用service注解，因为会与dubbo中service注解混淆
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "上单是";
    }
}
