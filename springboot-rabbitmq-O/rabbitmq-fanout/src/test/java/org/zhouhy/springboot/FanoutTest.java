package org.zhouhy.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.component.sender.OrderSender;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {

    @Resource(name="orderSender")
    private OrderSender orderSender;

    @Test
    public void testOrderSender(){
        this.orderSender.send();
    }
}
