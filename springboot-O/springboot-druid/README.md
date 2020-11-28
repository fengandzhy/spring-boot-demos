## Overview
Druid is a project in Alibaba's open source platform. It is Composed by a database connection pool, plug-in frameworks and a SQL parser.
The main purpose of Druid is to address some limitations of JDBC and it allows programmers to implements some specific requirements, such as requesting credentials from secret key services, statisticing SQL information, SQL information collection, SQL injection checking, SQL interpretation, etc.   
https://github.com/alibaba/druid
Database connection pooling for monitoring, It has a backend monitoring system http://localhost:9090/druid 

# Steps to use druid in your spring boot project 

1. **update the maven file add the dependencies to your pom**：
```
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>druid-spring-boot-starter</artifactId>
	<version>1.1.18</version>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.19</version>
</dependency>
```
2. **update the application.properties**
```
spring.datasource.druid.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.druid.url=jdbc:mysql://127.0.0.1:3306/springboot-o?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC
spring.datasource.druid.username=root
spring.datasource.druid.password=root
spring.datasource.druid.driver-class-name=com.mysql.cj.jdbc.Driver
#初始化连接大小:连接池建立时创建的初始化连接数
spring.datasource.druid.initial-size=5
#最小空闲连接数:连接池中最小的活跃连接数
spring.datasource.druid.min-idle=15
#最大连接数:连接池中最大的活跃连接数
spring.datasource.druid.max-active=60
spring.datasource.druid.validation-query=SELECT 1
#获取连接时检测：是否在获得连接后检测其可用性
spring.datasource.druid.test-on-borrow=true
#空闲时检测：是否在连接空闲一段时间后检测其可用性
spring.datasource.druid.test-while-idle=true
#连接保持空闲而不被驱逐的最长时间
spring.datasource.druid.time-between-eviction-runs-millis=60000
```
3. **create a config java class**
```
@Configuration
public class DataSourceConfig {
    
    @Bean(name = "druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}
```
4. **unit test**
```
@Resource(name="druidDataSource")
private DataSource dataSource;

@Test
public void test() throws SQLException {
	System.out.println(dataSource.getClass().toString());
	Connection connection = dataSource.getConnection();
	System.out.println(connection.toString());
	connection.close();
}
```
