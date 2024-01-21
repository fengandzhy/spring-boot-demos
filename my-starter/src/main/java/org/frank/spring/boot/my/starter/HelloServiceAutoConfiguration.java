package org.frank.spring.boot.my.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class)
public class HelloServiceAutoConfiguration {

    HelloProperties helloProperties;

    @Bean
    HelloService helloService() {
        HelloService helloService = new HelloService();
//        helloService.setName("Frank");
//        helloService.setMsg("666");
        helloService.setName(helloProperties.getName());
        helloService.setMsg(helloProperties.getMsg());
        return helloService;
    }
}
