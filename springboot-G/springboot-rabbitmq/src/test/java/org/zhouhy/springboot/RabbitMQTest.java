package org.zhouhy.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.component.Sender;
import org.zhouhy.springboot.provider.direct.DirectSender;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

//    @Resource(name="basicSender")
//    private Sender sender;

    @Resource(name="directSender")
    private DirectSender directSender;


//    @Test
//    public void senderTest(){
//        this.sender.send();
//    }

    @Test
    public void directTest(){
        this.directSender.send();
    }
}
