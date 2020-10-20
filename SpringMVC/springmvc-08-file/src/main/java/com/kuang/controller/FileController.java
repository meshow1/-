package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Controller
public class FileController {

    @RequestMapping("/upload")
    //@RequestParam("file")CommonsMultipartFile file,把name为file的控件得到的文件封装成CommonsMultipartFIle对象，
    //若批量上传，使用List接收即可 ,最后下载的文件在out中
    public String upload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
//        通过CommonsMultipartFile的方法直接写文件
        file.transferTo(new File(realPath+"/"+file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")//从服务器下载文件, 正常在jsp中直接通过url连接访问文件就可下载了
    @ResponseBody
    public String downloads(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String path = request.getServletContext().getRealPath("/upload");
        String fileName="123.jpg";

        //设置response响应头
        response.reset();//设置页面不缓存，清空buffer
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipar/form-data");//二进制流传输
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));//以附件形式保存

        File file = new File(path, fileName);
        //读取文件
        FileInputStream input = new FileInputStream(file);
        //输出流
        ServletOutputStream out = response.getOutputStream();

        byte[] buffer = new byte[1024];
        int index = 0;
        //执行写
        while((index=input.read(buffer))!=-1){
            out.write(buffer, 0, index);
            out.flush();
        }

        out.close();
        input.close();
        return "ok";


    }
}
