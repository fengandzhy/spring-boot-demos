package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 以下是静态资源的加载顺序
 * classpath:/META-INF/resources/
 * classpath:/resources/
 * classpath:/static/
 * classpath:/public/
 *
 * */
@SpringBootApplication
public class ResourceApp {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApp.class,args);
    }
}
