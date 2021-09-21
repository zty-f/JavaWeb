package com.zty.servlet;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器3秒自动刷新一次；
        resp.setHeader("refresh","2");
        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(100, 20, BufferedImage.TYPE_INT_BGR);
        //得到图片
        Graphics2D g = (Graphics2D) image.getGraphics();
        //设置图片背景颜色
        g.setColor(Color.white);
        g.fillRect(0,0,100,20);
        //给图片写数据
        g.setColor(Color.blue);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);
        //告诉浏览器。这个请求用图片的方式打开
        resp.setContentType("image/jpeg");
        //网站存在缓存，不然浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //把图片写给浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
    //生成随机数
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(99999999)+"";
        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<=7-num.length();i++){
            buffer.append("0");
        }
        num = buffer.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
