package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Properties;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {

    //配置swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //获取项目环境, 通过环境选择是否开启swagger
        Profiles profiles = Profiles.of("dev", "test");//设置需要的环境名称
        boolean flag= environment.acceptsProfiles(profiles);//通过监听判断是否处在需要的环境中


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("姜")//配置分组名称,可以再建一个docket进行多个分组,比如下面的docket1
                //设置关闭swagger
                .enable(flag)
                //RequestHandlerSelectors配置要扫描接口的方式
                //select...build
                .select().apis(RequestHandlerSelectors.basePackage("com.kuang.controller"))//设置为只扫描controller下的接口
                .build();
    }
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("二号分组");
    }

    //更改一些默认的配置
    private ApiInfo apiInfo(){
        final Contact DEFAULT_CONTACT = new Contact("jiang", "url=...", "...@qq.com");
        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
