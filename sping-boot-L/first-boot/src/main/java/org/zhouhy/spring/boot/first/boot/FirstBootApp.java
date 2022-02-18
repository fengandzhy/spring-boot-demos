package org.zhouhy.spring.boot.first.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @EnableAutoConfiguration 可以实现扫描包的配置, 依据的是当前类所在的包,
 * */
//@EnableAutoConfiguration// 自动装配处理
@SpringBootApplication
public class FirstBootApp {
    public static void main(String[] args) {
        SpringApplication.run(FirstBootApp.class,args);
    }
}
