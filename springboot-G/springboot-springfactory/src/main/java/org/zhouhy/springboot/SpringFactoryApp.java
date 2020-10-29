package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.zhouhy.spring.MyBean;

@SpringBootApplication
public class SpringFactoryApp {
    public static void main(String[] args) {
       ConfigurableApplicationContext context =  SpringApplication.run(SpringFactoryApp.class,args);
       MyBean myBean = context.getBean(MyBean.class);
       System.out.println(myBean);
    }

}
