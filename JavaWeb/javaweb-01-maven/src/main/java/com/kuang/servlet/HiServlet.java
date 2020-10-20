package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HiServlet")
public class HiServlet extends HttpServlet {
    //查看上三层继承类，在Servlet类中存在service（）方法，调用doPost等方法，HttpServlet有默认的DoPost等方法，但我们需要自己实现方法，所以再次重写。
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        ServletOutputStream outputStream = response.getOutputStream();
        PrintWriter writer = response.getWriter();
        writer.print("doing doPost");

    }

    //get和post只是请求实现不同方式，可以相互调用，因未业务逻辑都一样（都是Http链接）
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
