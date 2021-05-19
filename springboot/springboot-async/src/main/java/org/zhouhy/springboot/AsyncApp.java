package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 这种异步线程池的需要这么以下几个步骤
 *  1) 先创建一个所有线程池的父类, 并在这个类标记上@EnableAsync
 * 
 * */
@SpringBootApplication
public class AsyncApp {

    public static void main(String[] args) {
        SpringApplication.run(AsyncApp.class,args);
    }
    
}
