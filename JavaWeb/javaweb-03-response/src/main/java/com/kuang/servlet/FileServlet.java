package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取文件路径
        String realPath = "D:\\JAVAprojects\\狂神说\\JavaWeb\\javaweb-03-response\\target\\classes\\截图.JPG";
        //2.下载的文件名
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //设置浏览器能够支持下载需要的文件
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename, "utf-8"));//转码为中文文件名
        //获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        int len=0;
        byte[] buffer=new byte[1024];
        //获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
        //将FileinputStrean流写入缓冲区 ,使用OutoutStrean将缓冲区的数据输出到客户端
        while ((len=in.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }

        //关闭流
        outputStream.close();
        in.close();




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
