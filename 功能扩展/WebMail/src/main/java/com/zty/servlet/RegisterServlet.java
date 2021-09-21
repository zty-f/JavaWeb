package com.zty.servlet;

import com.zty.pojo.User;
import com.zty.utils.Sendmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //接收用户请求，封装成对象
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            User user = new User(username,password,email);

            //用户注册成功之后，给用户发送一封邮件
            //我们使用线程来专门发送邮件，防止出现耗时，和网站注册人数过多的情况；
            Sendmail send = new Sendmail(user);
            //启动线程，线程启动之后就会执行run方法来发送邮件
            send.start();

            //注册用户
            request.setAttribute("message", "注册成功，我们已经发了一封带了注册信息的电子邮件，请查收！如网络不稳定，可能过会儿才能收到！！");
            request.getRequestDispatcher("info.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "注册失败！！");
            request.getRequestDispatcher("info.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
