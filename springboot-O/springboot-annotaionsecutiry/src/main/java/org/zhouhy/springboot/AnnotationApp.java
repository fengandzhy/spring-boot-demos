package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 用注解实现简单的权限控制功能
 * */
@SpringBootApplication
public class AnnotationApp {
    public static void main(String[] args) {
        SpringApplication.run(AnnotationApp.class,args);
    }
}
