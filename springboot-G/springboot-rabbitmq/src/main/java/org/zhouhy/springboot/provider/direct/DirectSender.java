package org.zhouhy.springboot.provider.direct;

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
    private String routinKey;

    public void send(){
        String msg = "hello "+new Date();
        this.amqpTemplate.convertAndSend(this.exchange,this.routinKey,msg);
    }
}
