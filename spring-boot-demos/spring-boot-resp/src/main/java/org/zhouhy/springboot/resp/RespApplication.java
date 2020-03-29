package org.zhouhy.springboot.resp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication (scanBasePackages = {"org.zhouhy.springboot.resp","org.zhouhy.springboot.commons"})
public class RespApplication {
    public static void main(String[] args) {
        SpringApplication.run(RespApplication.class,args);
    }
}
