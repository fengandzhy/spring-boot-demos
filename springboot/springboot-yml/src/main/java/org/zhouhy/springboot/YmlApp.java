package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 可以通过spring.profile.active的方式来决定使用哪个yml里面的配置 spring.profile.active 设置的是dev 那么就是application-dev.yml里面设置的东西起作用
 * 如果spring.profile.active 设置成 dev1 那么就是application-dev1.yml 里面的设置起作用
 * 
 * 2. lombok 中用@ToString 方法就是默认输出所有的属性
 * 
 * 
 *   
 * 
 * 
 * 
 * */
@SpringBootApplication
public class YmlApp {
    public static void main(String[] args) {
        SpringApplication.run(YmlApp.class,args);
    }
}
