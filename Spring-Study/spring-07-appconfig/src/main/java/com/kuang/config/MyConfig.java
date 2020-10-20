package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyConfig2.class)
@ComponentScan("com.kuang")
public class MyConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
