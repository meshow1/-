package com.kuang.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ScheduledService {

    //cron表达式
    //代表             秒 分 时 日 月 周几
    @Scheduled(cron = "0 * * * * 0-7")//每次0s时激活
    public void hello(){
        System.out.println("hello被执行了");
    }
}
