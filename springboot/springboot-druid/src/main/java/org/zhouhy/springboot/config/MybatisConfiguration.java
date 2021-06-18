package org.zhouhy.springboot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfiguration {

    final static String ACCOUNT_PREFIX = "spring.datasource.master";

    final static String REDPACKET_PREFIX = "spring.datasource.slaver";

    @Bean(name = "AccountDataSource")
    @ConfigurationProperties(prefix = ACCOUNT_PREFIX)  // application.properties中对应属性的前缀
    public DataSource accountDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "RedPacketDataSource")
    @ConfigurationProperties(prefix = REDPACKET_PREFIX)  // application.properties中对应属性的前缀
    public DataSource redPacketDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
