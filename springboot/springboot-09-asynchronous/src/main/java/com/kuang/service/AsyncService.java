package com.kuang.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync//在配置激活也可以
public class AsyncService {

    @Async//标识是异步方法，需要在配置中开启,会在后台调用这个方法，不影响程序继续运行
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据处理中");
    }
}
