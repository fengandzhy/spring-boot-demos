package org.zhouhy.springboot.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="sender")
public class Sender {
    
    @Autowired
    private AmqpTemplate template;
    
    public void send(){
        String msg = "hello rabbitmq";
        this.template.convertAndSend("hello-mq",msg);
    }
}
