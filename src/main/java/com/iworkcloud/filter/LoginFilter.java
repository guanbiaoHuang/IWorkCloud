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
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        //访问login.jsp时，才放过，并且login.jsp的后续操作，继续执行，不拦截
        if (servletPath.startsWith("/page/")) {
            if(session.getAttribute("staff")!=null) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            else{
                String contextPath=request.getContextPath();
                response.setCharacterEncoding("utf-8");
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                //否则拦截，跳转指定的页面
                pw.print("<script>window.top.location.href='"+contextPath + "/user/login'"+";</script>");
            }

        }else {
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}

