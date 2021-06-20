package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. @EnableConfigurationProperties注解的作用是：使使用 @ConfigurationProperties 注解的类生效。
 *  
 * 2. 关于配置多数据源的问题
 *  1) 配置yml 
 *  2) 在pom文件中引入相关依赖主要是指druid和mybatis的依赖
 *  3) 如果配置了filters: stat,wall,log4j 一定要在pom文件中配置log4j
 *  4) 配置数据源, 请参考本例中的MybatisConfiguration
 *  5) 配置SQL Session工厂
 *  6) 配置Sql Session模板
 *  7) 配置事务manager 
 *  
 * 3. 在service 用到@Transactional 的时候一定要注意指定是哪个manager 
 * @Transactional(rollbackFor = Exception.class,transactionManager="slaverTransactionManager")
 * 
 * 
 * */
@SpringBootApplication
public class DruidApp {
    public static void main(String[] args) {
        SpringApplication.run(DruidApp.class,args);
    }
}
