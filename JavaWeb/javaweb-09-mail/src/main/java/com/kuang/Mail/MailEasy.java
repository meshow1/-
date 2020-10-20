package com.kuang.Mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailEasy {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");//需要验证用户名和密码

        //qq邮箱需要加入下入代码设置ssl协议
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //发送邮件5个步骤
        //1.创建session对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1366364314@qq.com", "onbtuuuqnntuffei");
            }
        });

        //2.通过session得到transport对象
        Transport transport = session.getTransport();
        //3.使用邮箱用户名授权码连接服务器
        transport.connect("smtp.qq.com","","");//不输入用户名密码也可登录因为上面输入过了
        //4.创建邮件
        MimeMessage msg = new MimeMessage(session);
        msg.setSubject("test");
        msg.setFrom(new InternetAddress("1366364314@qq.com"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress("1522832963@qq.com"));
        msg.setContent("rsndg, wsnbb", "text/html;charset=UTF-8");

        //5。发送
        transport.sendMessage(msg, msg.getAllRecipients());

        //关闭
        transport.close();

    }
}
