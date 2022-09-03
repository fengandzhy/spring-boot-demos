package org.frank.microboot.service;

import org.frank.microboot.WebApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class) // 使用JUnit5测试工具
@WebAppConfiguration // 启动WEB运行环境
@SpringBootTest(classes = WebApp.class) // 配置程序启动类
public class MessageServiceImplTest {
    
    @Autowired
    private IMessageService messageService;
    
    @Test
    public void testEcho() {    // 进行响应测试
        String content = this.messageService.echo("沐言科技：www.yootk.com");
        String value = "【ECHO】沐言科技：www.yootk.com";
        System.err.println("【@Test】测试echo()方法返回值，当前放回结果为：" + content);
        Assertions.assertEquals(content, value); // 测试相等
    }
}
