package org.zhouhy.springboot.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhouhy.springboot.config.entity.Address;

@Configuration
public class MyConfig {

    /**
     * 这里的方法名就是相当于spring 配置文件中bean的id值
     * */
    @Bean
    public Address address(){
        return new Address();
    }
}
