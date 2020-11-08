package org.zhouhy.springboot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {


    @Bean
    public Queue queue(){
        return new Queue("hello-zhy");
    }

//    @Bean
//    public Queue queue1(){
//        return new Queue("hello-zhy1");
//    }
}