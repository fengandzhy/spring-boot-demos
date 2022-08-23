package org.example.spring.boot.beginning;

import org.example.spring.boot.beginning.banner.UnimarketBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeginningApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BeginningApp.class); // 获取实例化对象
        springApplication.setBanner(new UnimarketBanner()); // 配置自定义的Banner生成器
        springApplication.run(args); // 运行SpringBoot程序
    }
}
