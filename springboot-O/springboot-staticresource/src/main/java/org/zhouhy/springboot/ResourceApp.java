package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. Spring Boot 默认会挨个从META-INF/resources > resources > static > public  里面找是否存在相应的资源
 *
 * */
@SpringBootApplication
public class ResourceApp {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApp.class,args);
    }
}
