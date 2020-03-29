package org.zhouhy.springboot.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class RedisTaskConfiguration extends SyncConfiguration {

    @Bean(name = "redisPoolTaskExecutor")
    public ThreadPoolTaskExecutor getRedisTaskExecutor(){
        return this.getTaskExecutor("redis-");
    }
}
