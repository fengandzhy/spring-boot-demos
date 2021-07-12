package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 关于swagger有以下几个步骤
 *  1) 引入pom相关依赖
 *  2) 在yml 文件中spring.swagger2.enabled = true
 *  3) 设置相关config配置类SwaggerConfig, 在SwaggerConfig里面加入@EnableSwagger2, 设置basePackage
 *  4) 在vo上设置@ApiModelProperty 以及在 controller上设置 @ApiOperation 以便很好的解释
 *  
 *  
 * */
@SpringBootApplication
public class SwaggerApp {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApp.class,args);
    }
}
