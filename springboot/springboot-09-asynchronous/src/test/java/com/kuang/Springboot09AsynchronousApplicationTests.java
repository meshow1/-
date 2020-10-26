package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

//发送邮件测试
@SpringBootTest
class Springboot09AsynchronousApplicationTests {
    @Autowired//导入mail包中的实现类
    JavaMailSenderImpl mailSender;

    @Test//简单邮件
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("你好");
        mailMessage.setText("谢谢，。。。。。" +
                "。。。。。。。。。。。。。。。。。。" +
                "。。。。。。。。。。。。。。" +
                "。" +
                "。。。。。。。。。。。。。。。。。。。。。。" +
                "。。。。。。" +
                "best wish");
        mailMessage.setFrom("1366364314@qq.com");
        mailMessage.setTo("1366364314@qq.com");


        mailSender.send(mailMessage);
    }

    @Test//复杂邮件，带附件的邮件发送
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装起来
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("你好啊");
        helper.setText("是的撒 ");
        helper.setText("<p style='color:red'>牛逼牛</p>",true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\apple丶eye\\Desktop\\证件照\\1.jpg"));

        helper.setFrom("1366364314@qq.com");
        helper.setTo("1366364314@qq.com");
        mailSender.send(mimeMessage);

    }

}
