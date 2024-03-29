package org.zhouhy.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhouhy.springboot.service.UserService;

@Configuration
@ConditionalOnProperty(prefix = "hxstrive.service",
        name="user.enable",havingValue = "1",matchIfMissing = true)
public class ConditionalOnPropertyUserConfig {
    
    @Bean
    public UserService userService(){
        System.out.println("UserService -> userService()");
        return new UserService();
    }
}
