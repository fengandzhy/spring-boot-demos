package org.zhouhy.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhouhy.springboot.service.OrderService;


@Configuration
@ConditionalOnProperty(prefix = "hxstrive.service",
        name="order.enable",havingValue = "1",matchIfMissing = true)
public class ConditionalOnPropertyOrderConfig {

    @Bean
    public OrderService orderService(){
        System.out.println("OrderService -> orderService()");
        return new OrderService();
    }
}
