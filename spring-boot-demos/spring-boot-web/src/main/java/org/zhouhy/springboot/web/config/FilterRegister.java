package org.zhouhy.springboot.web.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhouhy.springboot.web.filter.FirstFilter;

@Configuration
public class FilterRegister {

    @Bean
    public FilterRegistrationBean getFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new FirstFilter());
        String[] urls = {"/index.html"};
        bean.addUrlPatterns(urls);
        return bean;
    }
}
