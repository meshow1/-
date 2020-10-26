package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问, 功能也只有对应权限的人访问
        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/level1/**").hasRole("vip1").
                antMatchers("/level2/**").hasRole("vip2").
                antMatchers("/level3/**").hasRole("vip3");

        // 没有权限会跳转到登录页面（默认是/login)
        // 主要意思是说他将/toLogin作为登录的响应显示界面(有一个默认的登录页面)，并将其中的username和password两个传递值作为
        // 默认的用户名和密码， 并定义/login页面映射到 /toLogin上，作为另一个登录访问入口.
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");

        //开启注销功能
        //关闭默认的csrf(跨站请求伪造)功能防止将一些框架功能屏蔽
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        //记住我功能,设置激活参数为“remember”
        http.rememberMe().rememberMeParameter("remember");
    }

    //认证， 自动导到/login 页面
    //密码编码 ：需要增加 passwordencoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //假设从内存取, 正常应该从数据库中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3");
    }
}
