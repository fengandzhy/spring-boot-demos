package org.frank.spring.boot.interceptor.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在Controller处理之前调用
        System.out.println("preHandle called");
        return true; // 返回true继续流程（如调用下一个拦截器或处理器）；返回false则中断流程。
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在Controller处理之后，视图渲染之前调用
        System.out.println("postHandle called");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在整个请求结束之后调用（即视图渲染之后）
        System.out.println("afterCompletion called");
    }
}
