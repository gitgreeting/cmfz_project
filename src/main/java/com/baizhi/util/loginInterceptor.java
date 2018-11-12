package com.baizhi.util;

import com.baizhi.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            HttpSession session = httpServletRequest.getSession();
            String requestURI = httpServletRequest.getRequestURI();
           Admin admin = (Admin)session.getAttribute("admin");
           System.out.println("-----------requestURI----------"+requestURI);
            System.out.println("---------admin--------"+admin);
          if(requestURI.indexOf("adminLogin")==-1){
              if(admin!=null){
                  return true;
              }
              httpServletResponse.sendRedirect("/cmfz_project/login.jsp");
              return false;
          }
          return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}