package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * 1. 可以通过spring.profile.active的方式来决定使用哪个yml里面的配置 spring.profile.active 设置的是dev 那么就是application-dev.yml里面设置的东西起作用
 * 如果spring.profile.active 设置成 dev1 那么就是application-dev1.yml 里面的设置起作用
 * 
 * 2. lombok 中用@ToString 方法就是默认输出所有的属性
 * 
 * 3. 注意本例中的yml 的写法, 当上一个层次的节点为空, 下一层次的节点才可以tab缩进. 例如 config 上一层次的节点是 mq, 而mq为空, 所以config 可以缩进
 * 而 diat 上一层节点是env 但是它不为空, 所以diat 不能缩进只能 env.diat 写成平级
 * 
 * 4. 这种方式取到yml 或 properties 里面的值 @Value("${mq.config.exchange}")
 *     
 * 5. @ConfigurationProperties(prefix = "user") 这也是种方式, 只不过用这种方式时候需要加入  spring-boot-configuration-processor 依赖
 * 
 * 6. @ConfigurationProperties(prefix = "brand") 和 @PropertySource(value = {"classpath:brand.properties"}) 联合使用也可以
 * 
 * 7. 注入org.springframework.core.env.Environment 然后利用 env.getProperty("mq.config.queue.info.routing.key") 取得值 这种方法用的少    
 *   
 * 8. @ImportResource 可以让spring boot读到额外的spring 配置文件  
 * 
 * 9. ApplicationContext 可以直接注入参考本例test5 
 * 
 * 10. 关于@EnableConfigurationProperties
 *  如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，
 *  那么在IOC容器中是获取不到properties 配置文件转化的bean, 例如本例的User1就是这样
 *  说白了 @EnableConfigurationProperties 相当于把使用 @ConfigurationProperties 的类进行了一次注入。
 *  例如在本例中EnableUser1这个类中@EnableConfigurationProperties(User1.class) 就相当于把
 *  User1这个@ConfigurationProperties 的类重新注入到了IOC容器中
 *  但是@EnableConfigurationProperties 一定要跟@Configuration联用
 *  
 *
 * 
 * 
 * 
 * */
@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class YmlApp {
    public static void main(String[] args) {
        SpringApplication.run(YmlApp.class,args);
    }
}
