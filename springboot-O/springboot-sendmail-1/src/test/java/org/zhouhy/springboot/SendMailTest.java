package org.zhouhy.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.service.IMailService;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailTest {
    
    @Resource(name="IMailService")
    private IMailService iMailService;
    
    @Test
    public void sendSimpleMailTest(){
        String to = "fengandzhy@126.com";
        String subject = "Test";
        String content = "Hello world!";
        iMailService.sendSimpleMail(to,subject,content);
    }
}
