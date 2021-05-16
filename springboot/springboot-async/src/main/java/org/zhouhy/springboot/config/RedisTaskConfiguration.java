package org.zhouhy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class RedisTaskConfiguration extends AsyncConfiguration{
    
    @Bean(name="redisTaskExecutor")
    public ThreadPoolTaskExecutor getRedisTaskExecutor(){
        return this.getTaskExecutor("redis-");
    }
}
