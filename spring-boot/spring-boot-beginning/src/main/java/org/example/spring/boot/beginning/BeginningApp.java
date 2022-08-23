package org.example.spring.boot.beginning;

import org.example.spring.boot.beginning.banner.UnimarketBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeginningApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BeginningApp.class);
        springApplication.setBanner(new UnimarketBanner());
        springApplication.run(args);
    }
}
