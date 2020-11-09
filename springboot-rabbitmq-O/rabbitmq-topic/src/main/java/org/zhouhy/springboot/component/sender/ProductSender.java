package org.zhouhy.springboot.component.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value="productSender")
public class ProductSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;    

    public void send(){
        this.amqpTemplate.convertAndSend(this.exchange,"product.log.info","product info in product.log.info");
        this.amqpTemplate.convertAndSend(this.exchange,"product.log.error","product error in product.log.error");
        this.amqpTemplate.convertAndSend(this.exchange,"product.log.warn","product warn in product.log.warn");
        this.amqpTemplate.convertAndSend(this.exchange,"product.log.debug","product debug in product.log.debug");
    }
    
}
