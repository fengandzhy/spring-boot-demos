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
        this.amqpTemplate.convertAndSend(this.exchange,"","您的订单已经完成！");        
    }
    
}
