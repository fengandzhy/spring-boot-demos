package org.zhouhy.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource 可以让spring boot读到额外的spring 配置文件
 * 在yml文件中加debug: true 后能看到很多 CONDITIONS EVALUATION REPORT
 * */
//@ImportResource("classpath:spring.xml")
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}
