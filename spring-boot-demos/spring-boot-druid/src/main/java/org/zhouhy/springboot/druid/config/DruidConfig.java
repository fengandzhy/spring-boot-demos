package org.zhouhy.springboot.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    @Bean(name="masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource(){
       //return new DruidDataSource();
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="slaverDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slaver")
    public DataSource slaverDataSource(){
        return new DruidDataSource();
    }
}
