package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 注意本例用MockMvc来测试访问controller 
 * 
 * 
 * 
 * */
@SpringBootApplication
public class MockMvcApp {
    public static void main(String[] args) {
        SpringApplication.run(MockMvcApp.class,args);
    }
}
