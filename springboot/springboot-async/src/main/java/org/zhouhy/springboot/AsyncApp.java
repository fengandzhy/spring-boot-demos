package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 这种异步线程池的需要这么以下几个步骤
 *  1) 先创建一个所有线程池的父类, 并在这个类标记上@EnableAsync 和 @Configuration
 *  2) 创建线程池子类, 例如CreditTaskConfiguration
 *  3) 在service的相应方法上加入相应的线程池@Async("redisTaskExecutor")
 * 
 * 
 * 
 * */
@SpringBootApplication
public class AsyncApp {

    public static void main(String[] args) {
        SpringApplication.run(AsyncApp.class,args);
    }
    
}
