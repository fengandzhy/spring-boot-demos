package org.zhouhy.springboot.component.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings=@QueueBinding(value=@Queue(value="${mq.config.queue.info}",autoDelete = "true"),
                        exchange = @Exchange(value="${mq.config.exchange}",type=ExchangeTypes.DIRECT),
                        key="${mq.config.queue.info.routing.key}"))
public class InfoReceiver {
    
    @RabbitHandler
    public void receive(String msg){
        System.out.println("INFO接收到消息："+msg);
    }
}
