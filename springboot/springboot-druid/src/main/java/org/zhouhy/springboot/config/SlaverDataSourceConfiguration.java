package org.zhouhy.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"org.zhouhy.springboot.mapper.slaver"}, sqlSessionFactoryRef = "slaverSqlSessionFactory")
public class SlaverDataSourceConfiguration {

    /**
     * mybatis的xml文件.
     */
    public static final String MAPPER_XML_LOCATION = "classpath*:org/zhouhy/springboot/mapper/slaver/xml/*.xml";

    @Autowired
    @Qualifier("slaverDataSource")
    DataSource slaverDataSource;

    @Bean
    public SqlSessionTemplate slaverSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(slaveSqlSessionFactory());
    }

    /**
     * 配置SQL Session工厂
     */
    @Bean(name="slaverSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(slaverDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return factoryBean.getObject();
    }

    /**
     *  配置事务
     */
    @Bean(name="slaverTransactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(slaverDataSource);
    }
    
}
