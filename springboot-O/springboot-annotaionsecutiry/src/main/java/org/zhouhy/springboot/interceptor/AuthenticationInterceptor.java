package org.zhouhy.springboot.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zhouhy.springboot.annotation.Access;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod)handler;

        Method method = handlerMethod.getMethod();

        Access access = method.getAnnotation(Access.class);

        if(access == null){
            return true;
        }

        if(access.authorities().length>0){
            String[] authorities = access.authorities();
            Set<String> authSet = new HashSet<>();
            for(String authority:authorities){
                authSet.add(authority);
            }
            String role = request.getParameter("role");
            if(!StringUtils.isEmpty(role)){
                if(authSet.contains(role)){
                   return true;
                }
            }
        }
        return false;
    }
}
