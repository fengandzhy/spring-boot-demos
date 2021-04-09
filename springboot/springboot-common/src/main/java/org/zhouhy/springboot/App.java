package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1.统一格式的JSON返回数据分成以下几步
 *  1) 状态码枚举类
 *  2) 定义返回实体类
 *  3) 定义这个实现了ResponseBodyAdvice 接口的类
 * 2. 在这个实现了ResponseBodyAdvice 接口的类当中加上 
 * 
 * 
 * 
 * */

@SpringBootApplication
public class App {
    
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
