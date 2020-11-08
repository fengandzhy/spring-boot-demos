package org.zhouhy.springboot.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    
    
    @RabbitListener(queues={"hello-mq"})
    public void receive(String msg){
        System.out.println(msg);
        System.out.println("接受消息完毕！");
    }
}
