package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 让service 里面的某些方法变成异步任务，这样就更加的有效率，例如注册时发送消息,如果这个发送消息是异步任务那无疑将提高系统效率
 * 主要注意以下两点
 * 1.@EnableAsync 表示允许异步任务开启
 * 2.@Bean(name="msgTaskExecutor") 必须注释在有返回 ThreadPoolTaskExecutor的方法上,就相当于给这个线程池起了个名字
 * 3.@Async("msgTaskExecutor") 在这个注释下面的方法将会被msgTaskExecutor 这个线程池异步执行
 *
 * */

@SpringBootApplication
public class AsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class,args);
    }
}
