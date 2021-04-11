package org.zhouhy.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.config.Brand;
import org.zhouhy.springboot.config.Car;
import org.zhouhy.springboot.config.User;
import org.zhouhy.springboot.config.YmlReader;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class YmlTest {
    
    @Autowired
    private YmlReader reader;
    
    @Autowired
    private User user;
    
    @Autowired
    private Brand brand;

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext applicationContext;
    
    @Test
    public void test1(){
        log.info(reader.getEnv());
        log.info(reader.getDiat());
        log.info(reader.getExchange());
        log.info(reader.getError());
        log.info(reader.getErrorRoutine());
        log.info(reader.getErrorRoutineKey());
        log.info(reader.getInfo());
        log.info(reader.getInfoRoutine());
        log.info(reader.getInfoRoutineKey());
    }

    @Test
    public void test2(){
        log.info(user.toString());        
    }

    @Test
    public void test3(){
        log.info(brand.toString());
    }

    @Test
    public void test4(){
        log.info(env.getProperty("mq.config.queue.info.routing.key"));
    }

    @Test
    public void test5(){
        Car car = (Car)applicationContext.getBean("car");
        log.info(car.getName());
    }
}
