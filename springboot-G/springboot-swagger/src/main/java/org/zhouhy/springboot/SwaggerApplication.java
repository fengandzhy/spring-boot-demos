package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. pom 文件中引入swagger和swagger-ui
 * 2. yml文件中设置
 * 3. 配置SwaggerConfig类
 * 4. 访问http://localhost:8080/swagger-ui.html#/user-controller
 *
 * */

@SpringBootApplication
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class,args);
    }
}
