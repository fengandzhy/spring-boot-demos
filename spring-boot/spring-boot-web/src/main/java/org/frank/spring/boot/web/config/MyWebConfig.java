package org.frank.spring.boot.web.config;

import org.frank.spring.boot.web.components.MySecondFilter;
import org.frank.spring.boot.web.components.MySecondListener;
import org.frank.spring.boot.web.components.MySecondServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyWebConfig {

    /**
     * 注册 servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        MySecondServlet mySecondServlet = new MySecondServlet();
        return new ServletRegistrationBean(mySecondServlet, "/my_secondServlet");        
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        MySecondFilter myFiler = new MySecondFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFiler);
        //注册该过滤器需要过滤的 url
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my_secondServlet"));
        return filterRegistrationBean;
    }
    /**
     * 注册监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        MySecondListener myListener = new MySecondListener();
        return new ServletListenerRegistrationBean(myListener);
    }
}
