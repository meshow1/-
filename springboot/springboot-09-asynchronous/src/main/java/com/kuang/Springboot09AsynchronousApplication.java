package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableAsync
//@EnableScheduling//开启定时注解
public class Springboot09AsynchronousApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09AsynchronousApplication.class, args);
    }

}
