package org.zhouhy.springboot.validate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.zhouhy.springboot.validate","org.zhouhy.springboot.commons"})
//@SpringBootApplication
public class ValidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateApplication.class,args);
    }
}
