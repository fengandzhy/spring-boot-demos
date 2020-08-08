package org.zhouhy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class CreditTaskConfiguration extends SyncConfiguration{

    @Bean(name="creditTaskExecutor")
    public ThreadPoolTaskExecutor getCreditTaskExecutor(){
        return this.getTaskExecutor("credit-");
    }
}
