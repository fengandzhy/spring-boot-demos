package org.example.spring.boot.configuration.controller;

import org.example.spring.boot.configuration.ConfigurationApp;
import org.example.spring.boot.configuration.controllers.MessageController;
import org.example.spring.boot.configuration.services.MessageService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class) // 使用JUnit5测试工具
//@WebAppConfiguration // 启动WEB运行环境
@SpringBootTest(classes = ConfigurationApp.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 配置程序启动类
public class MessageControllerTest {

    @Autowired
    private MessageController controller;

    @Autowired
    private TestRestTemplate template;

    @BeforeAll
    public static void init() {
        System.err.println("【@BeforeAll】开始执行测试操作。");
    }
    @AfterAll
    public static void after() {
        System.err.println("【@AfterAll】测试完成。");
    }

    /**
     * 测试这个的时候, 必须保证服务器是运行的也就是说 ConfigurationApp 是运行的
     * */
    @Test
    public void testGetRequest() {
        String url = "http://localhost:8082/api/v1/message/list";
        ResponseEntity<String> entity = template.getForEntity(url, String.class);
        System.out.println(entity.getStatusCode());
    }

    @Test
    public void testListMessages() {
        String str = this.controller.listMessages();
        Assertions.assertEquals("listMessage", str);
    }
}
