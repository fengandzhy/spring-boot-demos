package org.zhouhy.springboot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.component.sender.DirectSender;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectTest {
    
    @Resource(name="directSender")
    private DirectSender directSender;
    
    @Test
    public void testSend(){
        this.directSender.send();
    }
}
