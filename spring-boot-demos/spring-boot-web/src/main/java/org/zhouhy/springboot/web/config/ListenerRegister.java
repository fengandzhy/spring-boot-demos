package org.zhouhy.springboot.web.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhouhy.springboot.web.listener.FirstListener;

@Configuration
public class ListenerRegister {

    @Bean
    public ServletListenerRegistrationBean getListener(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new FirstListener());
        return bean;
    }
}
