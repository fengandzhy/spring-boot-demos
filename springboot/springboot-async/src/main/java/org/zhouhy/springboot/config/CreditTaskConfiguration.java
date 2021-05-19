package org.zhouhy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
public class CreditTaskConfiguration extends AsyncConfiguration{
    
    @Bean(name="creditTaskExecutor")
    public ThreadPoolTaskExecutor getCreditTaskExecutor(){
        return this.getTaskExecutor("credit-");
    }
}
