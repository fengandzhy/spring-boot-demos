package org.zhouhy.springboot.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.zhouhy.springboot.properties.SecurityProperties;
import org.zhouhy.springboot.properties.UserProperties;

@Configuration
@EnableConfigurationProperties({SecurityProperties.class})
public class PropertiesConfig {
}
