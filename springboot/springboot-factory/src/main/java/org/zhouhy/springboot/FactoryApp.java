package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import spring.*;

/**
 * 1. spring.factories 在resource/META-INF下面, 它的作用将里面记录的bean注入到spring ioc 当中去
 * 由于本例中有@EnableAutoConfiguration 所以本例中配置的spring.factories 的key 一律都是
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration.
 * 
 * 2. 本例中是讲一个类FileRead和一个配置类MyConfig配置到了spring.factories, 这样一来FileRead 和 MyConfig里面配置的@Bean
 * 都能在IOC容器里找到
 * 
 * 3. @ImportResource 可以让spring boot读到额外的spring 配置文件
 * 
 * 4. @Import 将其他类引入IOC容器中去, 打个比方说在MyConfig里面加入@Import({MyBean1.class}) 就等于是把spring.MyBean1 
 * 引入了IOC容器
 * 
 * 
 * */
@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class FactoryApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FactoryApp.class,args);
        MyBean myBean = context.getBean("myBean",MyBean.class);
        System.out.println(myBean.info());
        MyListener myListener = context.getBean(MyListener.class);
        System.out.println(myListener);
        FileRead fileRead = context.getBean("fileRead",FileRead.class);
        System.out.println(fileRead);

        MyBean1 myBean1 = context.getBean("spring.MyBean1",MyBean1.class);
        System.out.println(myBean1.info());
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
//        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
//        System.out.println("--------------------------------------------------------");
//        for (String beanDefinitionName: beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//        System.out.println("--------------------------------------------------------");
    }   
}
