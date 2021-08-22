package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.zhouhy.springboot.config.ConditionalOnPropertyOrderConfig;
import org.zhouhy.springboot.config.ConditionalOnPropertyUserConfig;

/**
 * 1. 关于这个@Import 
 *  1) 如果该类实现了 ImportSelector 接口，Spring 容器就会实例化该类，并且调用其 selectImports 方法；
 *  2) 如果该类实现了 DeferredImportSelector 接口，则 Spring 容器也会实例化该类并调用其 selectImports方法。
 *  DeferredImportSelector 继承了 ImportSelector，区别在于 DeferredImportSelector 实例的 selectImports 方法调用时机晚于 ImportSelector 的实例，
 *  要等到 @Configuration 注解中相关的业务全部都处理完了才会调用；
 *  3) 如果该类实现了 ImportBeanDefinitionRegistrar 接口，Spring 容器就会实例化该类，并且调用其 registerBeanDefinitions 方法
 *  4) 如果该类没有实现上述三种接口中的任何一个，Spring 容器就会直接实例化该类。
 * 
 * 2. @ConditionalOnProperty 注解用于判断是否存在指定的属性，以及判断属性的值是否是我们期待的值.
 *  1) 如果在本例子中显示@ConditionalOnProperty(prefix = "hxstrive.service",
 *  name="order.enable",havingValue = "1",matchIfMissing = true) 
 *  则表示hxstrive.service.order.enable=1的时候 才会加载配置也就是说@Configuration 里面的@Bean才起作用
 *  2) matchIfMissing = true 表示如果没有上述配置也能加载
 * 
 * 3. 被@Bean 标识的bean也能正常加载进自动配置
 * 
 * */

@SpringBootApplication
@Import({ ConditionalOnPropertyOrderConfig.class, ConditionalOnPropertyUserConfig.class })
public class AutoConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(AutoConfigApp.class,args);
    }
}
