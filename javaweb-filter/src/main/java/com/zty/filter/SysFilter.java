/**
 * @author: zty
 * @program: javaweb-filter
 * @ClassName SysFilter
 * @description:
 * @create: 2021-08-16 16:57
 * @Version 1.0
 **/
package com.zty.filter;

import com.zty.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute(Constant.USER_SESSION)==null){
            response.sendRedirect("/error.jsp");
        }
        System.out.println("使用了过滤器！");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
