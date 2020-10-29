package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("org.zhouhy.springboot.mybatis.mapper")
@SpringBootApplication
public class MybatisApp {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApp.class,args);
    }
}
