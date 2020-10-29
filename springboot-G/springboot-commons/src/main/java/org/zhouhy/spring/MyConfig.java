package org.zhouhy.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    MyBean myBean(){
        return new MyBean();
    }

}
