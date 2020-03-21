package org.zhouhy.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 1. 这里如果有拦截器，首先要定义个拦截器 implements HandlerInterceptor, 然后在注册进来
 * 但是拦截器里的所有地址，都必须是controller里面注册过的额地址 比方说，在DemoConfig 里面的 /login.html
 * 那么意味着在controller 里面@RequestMapping里面也必须要有一个地址是 /login.html。 同理在LoginInterceptor
 * 里面的地址，例如request.getRequestDispatcher("/login.html") 这里的login.html 也必须是controller 里面的
 * 另外就是说，如果是post请求过来的，例如登录的/login，在这里被拦截后，也会发post请求到这个controller里面
 *
 * 在这里尽量用response.sendRedirect("/login.html");因为request.getRequestDispatcher("/login.html").forward(request,response);
 * 这个只是转发请求，如果原来是post请求，转发的也会是post请求
 *
 * */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("In the interceptor!");
        HttpSession session = request.getSession();
        if(session.getAttribute("loginUser") == null){
            request.setAttribute("loginErr","Please login");
            //request.getRequestDispatcher("/login.html").forward(request,response);
            response.sendRedirect("/login.html?ac=1");
            return false;
        }
        return true;
    }
}
