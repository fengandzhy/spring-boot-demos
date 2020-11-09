package org.zhouhy.springboot.component.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value="userSender")
public class UserSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    

    public void send(){
        this.amqpTemplate.convertAndSend(this.exchange,"user.log.info","user info in user.log.info");
        this.amqpTemplate.convertAndSend(this.exchange,"user.log.error","user error in user.log.error");
        this.amqpTemplate.convertAndSend(this.exchange,"user.log.warn","user warn in user.log.warn");
        this.amqpTemplate.convertAndSend(this.exchange,"user.log.debug","user debug in user.log.debug");
    }
    
}
