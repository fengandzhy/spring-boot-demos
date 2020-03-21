package org.zhouhy.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * 1. 这里如果有拦截器，首先要定义个拦截器 implements HandlerInterceptor, 然后在注册进来
 * 但是拦截器里的所有地址，都必须是controller里面注册过的额地址 比方说，在DemoConfig 里面的 /login.html
 * 那么意味着在controller 里面@RequestMapping里面也必须要有一个地址是 /login.html。 同理在LoginInterceptor
 * 里面的地址，例如request.getRequestDispatcher("/login.html") 这里的login.html 也必须是controller 里面的
 * 另外就是说，如果是post请求过来的，例如登录的/login，在这里被拦截后，也会发post请求到这个controller里面
 *
 *
 * */
@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    /**
     * 查看配置的事物管理器
     * */
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        log.info(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return null;
    }


    /**
     * 自定义事物管理器
     * */
//    @Bean
//    public PlatformTransactionManager txManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
