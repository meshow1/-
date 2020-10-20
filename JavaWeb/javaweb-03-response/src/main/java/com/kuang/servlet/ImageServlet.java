package com.kuang.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        //如何让浏览器5s自动刷新
        resp.setHeader("refresh","2");
        //在内存中创建图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //绘制图片,Graphics相当于一支笔，2D是2维的
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        //设置背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,80,20);
        //给图片写数据
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeNum(), 0, 20);

        //告诉浏览器这个请求用图片方式打开
        resp.setContentType("image/jpeg");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写给浏览器
        ImageIO.write(image, "jpg",resp.getOutputStream());

    }

    //生成随机数
    private String makeNum(){
        Random random = new Random();
        String num=random.nextInt(99999999)+"";
        StringBuffer sb = new StringBuffer();

        //保证数字是8位数,不足8位用0填充
        for(int i=0;i<8-num.length();i++){
            sb.append("0");
        }
        String s= sb.toString()+num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
