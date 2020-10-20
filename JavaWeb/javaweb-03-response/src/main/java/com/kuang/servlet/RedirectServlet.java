package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向与转发的区别
        //重定向的时候地址栏会变化，浏览器再次发送获取重定向的页面。
        //而转发的地址栏不会变化，由servlet与转发的页面进行交互，再传回浏览器

        //重定向
        resp.sendRedirect("/root/image");
//        重定向等价于
//        resp.setHeader("Location","/root/image");
//        resp.setStatus(302);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
