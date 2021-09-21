package com.zty.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class HelloServlet extends HttpServlet {
    //由于get或者post只是请求实现的方式不同，可以相互调用，业务逻辑都一样！
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入了doGet方法！");
        //ServletOutputStream outputStream = response.getOutputStream();
        PrintWriter writer = response.getWriter();//响应流
        writer.println("Hello Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
