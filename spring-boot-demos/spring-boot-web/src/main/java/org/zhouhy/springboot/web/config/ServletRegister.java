package org.zhouhy.springboot.web.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhouhy.springboot.web.servlet.AnotherServlet;
import org.zhouhy.springboot.web.servlet.FirstServlet;

@Configuration
public class ServletRegister {

    @Bean
    public ServletRegistrationBean getServlet1(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new AnotherServlet());
        bean.addUrlMappings("/another.html");
        return bean;
    }

    @Bean
    public ServletRegistrationBean getServlet2(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new FirstServlet());
        bean.addUrlMappings("/first.html");
        return bean;
    }
}
