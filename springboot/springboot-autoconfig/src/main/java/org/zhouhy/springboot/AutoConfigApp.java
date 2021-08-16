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
 *  
 * 
 * 
 * 
 * */

@SpringBootApplication
@Import({ ConditionalOnPropertyOrderConfig.class, ConditionalOnPropertyUserConfig.class })
public class AutoConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(AutoConfigApp.class,args);
    }
}
