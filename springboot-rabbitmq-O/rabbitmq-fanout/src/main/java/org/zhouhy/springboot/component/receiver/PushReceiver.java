package org.zhouhy.springboot.component.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings=@QueueBinding(value=@Queue(value="${mq.config.queue.push}",autoDelete = "true"),
        exchange = @Exchange(value="${mq.config.exchange}",type=ExchangeTypes.FANOUT)))
public class PushReceiver {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("推送服务收到信息："+msg);
    }
}
