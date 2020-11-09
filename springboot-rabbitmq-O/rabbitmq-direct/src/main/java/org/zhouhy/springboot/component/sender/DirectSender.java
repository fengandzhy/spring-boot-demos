package org.zhouhy.springboot.component.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value="directSender")
public class DirectSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    @Value("${mq.config.queue.info.routing.key}")
    private String routineKey;

    @Value("${mq.config.queue.error.routing.key}")
    private String errorRoutineKey;

    public void send(){
        String msg = "hello "+new Date();
        this.amqpTemplate.convertAndSend(this.exchange,this.routineKey,msg);
        this.amqpTemplate.convertAndSend(this.exchange,this.errorRoutineKey,msg);
    }
    
}
