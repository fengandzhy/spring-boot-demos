package org.zhouhy.springboot.druid.web;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidMonitor {

    @Bean
    public ServletRegistrationBean getDruidMonitorServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet());
        bean.setUrlMappings(Arrays.asList(new String[]{"/druid/*"}));
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean getDruidFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        bean.setUrlPatterns(Arrays.asList(new String[]{"/*"}));
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,*.jpg,*.png,/druid/*");
        bean.setInitParameters(initParams);
        return bean;
    }
}
