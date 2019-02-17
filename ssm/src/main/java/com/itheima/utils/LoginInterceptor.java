package com.itheima.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if(handler instanceof DefaultServletHttpRequestHandler){
            return true;
        }
        //如果session不为空，让其访问
        HttpSession session = request.getSession();
        if (session.getAttribute("user")!=null){
            return true;
        }
       response.sendRedirect(request.getContextPath()+"/index.jsp");
        return false;
    }
}
