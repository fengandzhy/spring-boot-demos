package org.frank.spring.boot.event;

import org.frank.spring.boot.event.publisher.CustomEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringEventDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringEventDemoApplication.class,args);
        CustomEventPublisher publisher = applicationContext.getBean(CustomEventPublisher.class);
        publisher.publishEvent("Hello Spring Events!");
    }
}
