package org.zhouhy.springboot.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.zhouhy.springboot.exception","org.zhouhy.springboot.commons"})
public class ExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class,args);
    }
}
