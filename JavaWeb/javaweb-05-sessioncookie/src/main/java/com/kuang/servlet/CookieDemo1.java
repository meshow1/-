package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存上一次访问的时间
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置浏览器响应显示编码
        resp.setContentType("text/html;charset=UTF-8");
        //在get请求中，设置获取请求编码，因为浏览器默认编码utf-8，servlet编码为IS0，所以需要进行一次解码和一次编码操作，在新版servlet中已经解决了这个
//        问题，所以不需要再设置了。
//        new String(xxx.getBytes("ISO-8859-1"),"UTF-8");

        //在post请求中，设置请求编码
//        req.setCharacterEncoding("utf-8");


        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        //判断cookie是否存在
        //cookie保存在服务器端
        if(cookies!=null){
            //如果存在cookie
            out.write("上一次访问时间是");

            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lastLoginTime")){
                    long time = Long.parseLong(cookie.getValue());
                    Date date = new Date(time);
                    out.write(date.toString());

                }
            }


        }else{
            out.write("第一次访问本站");
        }

        //服务器给客户端一个cookie
        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        //存活时间
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
