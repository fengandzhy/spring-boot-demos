package org.zhouhy.springboot.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class Receiver {

    @RabbitListener(queues = {"hello-zhy"})
    public void process(String msg){
        log.info("receiver:"+msg);
    }
}
