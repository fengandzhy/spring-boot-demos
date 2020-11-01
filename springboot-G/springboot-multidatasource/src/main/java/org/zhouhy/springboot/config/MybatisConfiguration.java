package org.zhouhy.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * 你在这里配了两个数据源,那就必须两个数据源的Configuration 来消耗掉它
 * 如果只有一个数据源的Configuration 它就会启动报错
 * */
@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfiguration {

    private static final String ACCOUNT_PREFIX = "spring.datasource.druid.account";

    private static final String REDPACK_PREFIX= "spring.datasource.druid.redpacket";

    @Bean
    @ConfigurationProperties(prefix = ACCOUNT_PREFIX)
    @Primary
    public DataSource accountDataSource(){
        return DataSourceBuilder.create().build();
        //return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = REDPACK_PREFIX)
    public DataSource redpackDataSource(){
        return DataSourceBuilder.create().build();
    }
}
