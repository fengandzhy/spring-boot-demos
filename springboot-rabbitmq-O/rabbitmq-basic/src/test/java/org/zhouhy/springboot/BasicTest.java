package org.zhouhy.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.component.Sender;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTest {
    
    @Resource(name="sender")
    private Sender sender;

    @Test
    public void sendTest(){
        this.sender.send();
    }
}
