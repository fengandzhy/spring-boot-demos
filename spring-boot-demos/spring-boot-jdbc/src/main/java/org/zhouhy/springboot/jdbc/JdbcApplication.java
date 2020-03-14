package org.zhouhy.springboot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 注意，这里如果要是的DataSource被正确注入，
 * 1. 引入的是javax.sql.DataSource;
 * 2. 在properties 文件中找到的必须是spring.datasource.driver-class-name=com.mysql.jdbc.Driver
 * 3. 在pom 文件中 必须加入jdbc的 starter
 * */

@SpringBootApplication
public class JdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class,args);
    }
}
