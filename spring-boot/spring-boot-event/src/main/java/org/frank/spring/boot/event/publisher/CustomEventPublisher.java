package org.frank.spring.boot.event.publisher;


import org.frank.spring.boot.event.events.CustomEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomEventPublisher {
    
    
    private ApplicationContext applicationContext;
    
    public void publishEvent(String message){
        // 创建一个新的CustomEvent对象
        CustomEvent customEvent = new CustomEvent(message);
        // 发布事件
        applicationContext.publishEvent(customEvent);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
