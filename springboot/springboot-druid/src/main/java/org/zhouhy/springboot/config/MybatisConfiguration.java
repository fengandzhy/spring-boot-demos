package org.zhouhy.springboot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfiguration {

    final static String ACCOUNT_PREFIX = "spring.datasource.master";

    final static String REDPACKET_PREFIX = "spring.datasource.slaver";
}
