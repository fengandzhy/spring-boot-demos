package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.zhouhy.springboot.config.ConditionalOnPropertyOrderConfig;
import org.zhouhy.springboot.config.ConditionalOnPropertyUserConfig;

@SpringBootApplication
@Import({ ConditionalOnPropertyOrderConfig.class, ConditionalOnPropertyUserConfig.class })
public class AutoConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(AutoConfigApp.class,args);
    }
}
