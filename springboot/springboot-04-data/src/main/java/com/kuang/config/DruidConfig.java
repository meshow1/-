package com.kuang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    //绑定properties
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控 :
    //配置servlet
    // 因为springboot内置了servlet容器，所以没有web.xml， 替代方法为ServletRegisterBean替代web.xml文件中servlet配置进行路径映射
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //将自带监控页面放在/druid/*下
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要登录账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");
        //允许谁访问
        initParameters.put("allow","");
        //禁止谁访问        initParameters.put("kuangshen","192.168.11.123");

        //配置初始化参数
       bean.setInitParameters(initParameters);
       return bean;
    }

    //配置filter过滤器, 同上面的servlet
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        //配置alibaba的过滤器进行过滤，调整控制监控的配置
        bean.setFilter(new WebStatFilter());
        //可以过滤哪些请求
        Map<String, String> initParameters = new HashMap<>();

        //这些不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");


        bean.setInitParameters(initParameters);
        return bean;
    }
}
