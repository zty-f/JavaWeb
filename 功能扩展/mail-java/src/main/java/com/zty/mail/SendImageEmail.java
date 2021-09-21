package com.zty.mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendImageEmail {
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");  //设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码

        // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //使用JavaMail发送邮件的5个步骤

        //1、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication("2559247260@qq.com", "eircgzlopgqaebcf");
            }
        });


        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        //2、通过session得到transport对象
        Transport ts = session.getTransport();

        //3、使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "2559247260@qq.com", "eircgzlopgqaebcf");

        //4、创建邮件

        //创建邮件
        MimeMessage message = new MimeMessage(session);

        // 设置邮件的基本信息
        //发件人
        message.setFrom(new InternetAddress("2559247260@qq.com"));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2559247260@qq.com"));
        //邮件标题
        message.setSubject("带图片的邮件");

        // 准备邮件数据

        // 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("D:\\IDEA_Project\\JavaWeb\\功能扩展\\mail-java\\src\\main\\resources\\1.jpg"));
        image.setDataHandler(dh);
        image.setContentID("1.jpg");

        // 准备正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src='cid:1.jpg'>的邮件", "text/html;charset=UTF-8");

        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");

        //设置到消息中，保存修改
        message.setContent(mm);
        message.saveChanges();

        //5.发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
}
