package org.zhouhy.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.component.sender.OrderSender;
import org.zhouhy.springboot.component.sender.ProductSender;
import org.zhouhy.springboot.component.sender.UserSender;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

    @Resource(name="orderSender")
    private OrderSender orderSender;

    @Resource(name="productSender")
    private ProductSender productSender;

    @Resource(name="userSender")
    private UserSender userSender;

    @Test
    public void testOrderSender(){
        this.orderSender.send();
    }

    @Test
    public void testUserSender(){
        this.userSender.send();
    }

    @Test
    public void testProductSender(){
        this.productSender.send();
    }
}
