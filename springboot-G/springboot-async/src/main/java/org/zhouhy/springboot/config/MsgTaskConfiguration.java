package org.zhouhy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class MsgTaskConfiguration extends SyncConfiguration {

    @Bean(name="msgTaskExecutor")
    public ThreadPoolTaskExecutor getMsgTaskExecutor(){
        return this.getTaskExecutor("Message-");
    }
}
