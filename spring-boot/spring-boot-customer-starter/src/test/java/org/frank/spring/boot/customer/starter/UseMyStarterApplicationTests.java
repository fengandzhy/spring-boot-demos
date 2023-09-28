package org.frank.spring.boot.customer.starter;

import org.frank.spring.boot.my.starter.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UseMyStarterApplicationTests {

    @Autowired
    HelloService helloService;
    
    @Test
    public void contextLoads() {
        System.out.println(helloService.sayHello());
    }
}
