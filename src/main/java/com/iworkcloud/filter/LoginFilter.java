package com.iworkcloud.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        //拦截访问路劲以以下前缀开始的地址
        if (servletPath.startsWith("/page/")) {
            //判断是否已经登陆
            if (session.getAttribute("staff") != null) {
                //放行
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            } else {
                //跳转至登陆界面
                String contextPath = request.getContextPath();
                response.setCharacterEncoding("utf-8");
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                //否则拦截，跳转指定的页面
                pw.print("<script>window.top.location.href='" + contextPath + "/user/login'" + ";</script>");
            }

        } else {
            //放行其他页的访问以及静态资源的访问
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}

