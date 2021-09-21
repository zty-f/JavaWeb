package com.zty.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        System.out.println("进入了ServletDemo04");
        //RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp"); //转发的请求路径
        //requestDispatcher.forward(req,resp); //调用forward实现请求转发；
        context.getRequestDispatcher("/s3").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
