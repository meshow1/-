package com.kuang.servlet;

import com.kuang.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //每个网站的session每次打开浏览器后一直用同一个,可以通过invalidate方法注销,也可以在配置中进行设置
        HttpSession session = req.getSession();
        session.setAttribute("name",new Person("姜",18));

        PrintWriter writer = resp.getWriter();
        writer.write("已经设置session中name属性");
        //print方法是对write的重写，将所有类型转为String类型后调用write方法
        //writer.print(XXXX);

        //获取id
        String id = session.getId();

        //session做了什么,session在cookie中设置一个id，通过id进行验证，并在服务器保存键值对（cookie是保存在浏览器的），用来保存一个用户登录的信息
//        Cookie cookie = new Cookie("JSESSIONID", id);
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
