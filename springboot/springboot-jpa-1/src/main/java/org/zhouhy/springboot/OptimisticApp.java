package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 关于这个driver-class-name: com.mysql.cj.jdbc.Driver, 他对这个mysql jar包版本也是有要求的, 8.0.13 是可以的
 * 
 * 2. 关于这个乐观锁, 因为将有很多线程来修改库存表(t_inventory)的库存值(inventory), 所以这个乐观锁是这么来加的
 *  1) 在Inventory 加入字段 version 并标注上@Version
 *  2) 乐观锁只是在修改的时候加锁, 所以在修改库存的时候需要加入version的判断, 我们只需要修改version 匹配的记录, 参看本例updateById 方法
 *  3) 记录每次修改的记录数, 如果修改记录失败, 就抛异常让整个事务回滚
 * 
 * 3. 关于这个jpa的依赖, 如果把spring-boot-starter-data-jpa 放到外面的父工程, 那就等于给所有的module加上了这个依赖
 * 加上这个依赖就必须要配置数据源的各种信息, 或者要在所有的module上加上
 * @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})这样带来极大不方便.
 * 
 * 
 * 
 * 
 * */
@SpringBootApplication
public class OptimisticApp {
    public static void main(String[] args) {
        SpringApplication.run(OptimisticApp.class,args);
    }
}
