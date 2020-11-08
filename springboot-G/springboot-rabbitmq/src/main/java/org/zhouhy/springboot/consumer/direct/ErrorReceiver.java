package org.zhouhy.springboot.consumer.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value=@Queue(value="${mq.config.queue.error}",autoDelete = "true"),
        exchange=@Exchange(value="${mq.config.exchange}",type = ExchangeTypes.DIRECT),
        key="${mq.config.queue.error.routing.key}"))
public class ErrorReceiver {

    @RabbitHandler
    public void process(String msg){
        log.info("ERROR接收到消息："+msg);
    }
}
