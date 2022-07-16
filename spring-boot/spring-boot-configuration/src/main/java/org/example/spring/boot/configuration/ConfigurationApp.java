package org.example.spring.boot.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource(locations = {"classpath:META-INF/spring/spring-*.xml"})
public class ConfigurationApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApp.class,args);
    }
}

