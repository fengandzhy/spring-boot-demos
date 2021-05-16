package org.zhouhy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class MsgTaskConfiguration extends AsyncConfiguration{
    
    @Bean("msgTaskExecutor")
    public ThreadPoolTaskExecutor getMsgTaskExecutor(){
        return this.getTaskExecutor("msg-");
    }
}
