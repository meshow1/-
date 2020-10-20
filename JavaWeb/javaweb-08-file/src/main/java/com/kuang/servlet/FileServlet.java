package com.kuang.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet("/upload.do")
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断表单是普通还是带文件的表单
        if(!ServletFileUpload.isMultipartContent(req)){
            return;
        }

        //创建文件保存目录，建议保存在WEB INF文件夹，用户无法直接访问
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if(!uploadFile.exists()){
            uploadFile.mkdir();
        }

        //缓存 临时文件，保存一些较大的需要定时删除的文件
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File file = new File(tmpPath);
        if(!file.exists()){
            file.mkdir();
        }

        //处理上传文件一般通过流获取，使用原生流request.getInputStream，操作麻烦，建议使用apache文件上传组件实现，common-file,其依赖
        //common-io组件

        //1. 创建DiskFileItemFactory对象，处理文件上传路径或者大小限制,可以不写有默认值
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建缓冲区，当上传文件大于缓冲区时，放到临时文件中
//        factory.setSizeThreshold(1024 * 1024);
//        factory.setRepository(file);

        //2.获取ServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);
        //3.处理上传文件
        //3.1把前端请求解析，将每一个表单内容(输入项)封装成FileItem对象，需要从ServletFileUpload对象中获取
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        for (FileItem fileItem : fileItems) {
            String msg="上传失败";
            //判断是文件表单还是普通表单
            if(fileItem.isFormField()){
                String name = fileItem.getFieldName();
                String value = fileItem.getString("UTF-8");//处理乱码
                System.out.println(name+":"+value);
            }else{//是文件情况下
                //============处理文件============================
                //文件名
                String uploadFileName = fileItem.getName();
                //判断文件名是否合法,不合法跳过
                if(uploadFileName.trim().equals("")||uploadFileName==null){
                    continue;
                }
                //获得上传文件名
                String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                //后缀
                String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
                //设置UUID作为通用吗，保证文件名唯一，UUID是一个native 接口调用操作系统实现
                String uuid = UUID.randomUUID().toString();

                //=================存放地址========================
                //存到uploadPath， 真实存在路径 realPath 给每个文件创建一个文件夹
                String realPath = uploadPath+"/"+uuid;
                File realPathFile = new File(realPath);
                if(!realPathFile.exists()){
                    realPathFile.mkdir();
                }

                //================文件传输===========================
                InputStream inputStream = fileItem.getInputStream();

                FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);

                byte[] buffer = new byte[1024*1024];
                int len=0;
                while((len = inputStream.read(buffer))!=-1){
                    fos.write(buffer, 0, len);
                }
                fos.close();
                inputStream.close();

                msg = "文件上传成功";
                fileItem.delete();//清除临时文件


            }
            //servlet请求转发消息
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/info.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
