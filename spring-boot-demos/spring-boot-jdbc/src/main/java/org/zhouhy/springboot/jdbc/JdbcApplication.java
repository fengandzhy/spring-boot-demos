package org.zhouhy.springboot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 注意，这里如果要是的DataSource被正确注入，
 * 1. 引入的是javax.sql.DataSource;
 *
 * 3. 在pom 文件中 必须加入jdbc的 starter
 * */

@SpringBootApplication
public class JdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class,args);
    }
}
