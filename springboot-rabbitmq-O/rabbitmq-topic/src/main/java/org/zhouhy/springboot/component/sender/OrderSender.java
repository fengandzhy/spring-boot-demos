package org.zhouhy.springboot.component.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component(value="orderSender")
public class OrderSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;


    public void send(){        
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.info","order info in order.log.info");
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.error","order error in order.log.error");
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.warn","order warn in order.log.warn");
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.debug","order debug in order.log.debug");
    }
    
}
