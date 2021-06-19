package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. @EnableConfigurationProperties注解的作用是：使使用 @ConfigurationProperties 注解的类生效。
 * 
 * 
 * 
 * */
@SpringBootApplication
public class DruidApp {
    public static void main(String[] args) {
        SpringApplication.run(DruidApp.class,args);
    }
}
