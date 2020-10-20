package com.kuang.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * com.kuang.service.BookService.*(..))")
    public void log1(){
        System.out.println("====================================");
    }

    @After("execution(public * com.kuang.service.BookService.*(..))")
    public void log2(){
        System.out.println("====================================");
    }
}
