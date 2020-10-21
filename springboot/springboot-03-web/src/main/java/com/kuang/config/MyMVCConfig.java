package com.kuang.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.Locale;

//扩展sb中的springmvc
@Configuration
//@EnableWebMvc//就是导入了一个DelegatingWebMvcConfiguration.class
//在webmvcautoconfiguration类中有这个注释@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)，所以当存在
//这个WebMvcConfigurationSupport.class时就会使自动配置失效，而EnableWEbMVC导入的DelegatingWebMvcConfiguration.class继承
//自WebMvcConfigurationSupport.class，所以@EnableWebMvc注解会导致自动配置失效，所以如果如果仅想重写某些方法，如官网所写，一定不要加
//这个注解
public class MyMVCConfig implements WebMvcConfigurer {
    //自己写的视图解析器
//    @Bean
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }

    //自定义视图解析器,并注入
//    public static class MyViewResolver implements ViewResolver{
//        @Override
//        public View resolveViewName(String s, Locale locale) throws Exception {
//            return null;
//        }
//    }

    //自己配置一个视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/kuang").setViewName("test");
    }
}


