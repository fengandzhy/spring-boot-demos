package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import spring.MyListener;
import spring.MyBean;

/**
 * 1. spring.factories 在resource/META-INF下面, 它的作用就是记录一些配置类信息
 * 
 * 
 * */
@SpringBootApplication
public class FactoryApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FactoryApp.class,args);
        MyBean myBean = context.getBean("myBean",MyBean.class);
        System.out.println(myBean.info());
        LoggingApplicationListener listener = context.getBean(LoggingApplicationListener.class);
        
    }
    
    
}
