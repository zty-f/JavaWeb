package com.zty.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

//中文数据传递
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        //Cookie，服务器从客户端获取
        Cookie[] cookies = req.getCookies(); //获得Cookie 可能存在多个cookie
        //判断cookie是否存在
        if (cookies!=null){
            //如果存在cookie怎么办
            for (Cookie cookie : cookies) {
                //获取cookie的信息
                if (cookie.getName().equals("name")){
                    //解码
                    //URLDecoder.decode(cookie.getValue(),"UTF-8");
                    System.out.println(URLDecoder.decode(cookie.getValue(),"UTF-8"));
                    out.write(URLDecoder.decode(cookie.getValue(),"UTF-8"));
                }
            }
        }
        //编码
        Cookie cookie = new Cookie("name", URLEncoder.encode("张天泳","utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
