package org.zhouhy.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.component.YmlReader;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class YmlTest {
    
    @Autowired
    YmlReader reader;
    
    @Test
    public void test1(){
        log.info(reader.getExchange());
        log.info(reader.getErrorRoutine());
        log.info(reader.getErrorRoutineKey());
        log.info(reader.getInfoRoutine());
        log.info(reader.getInfoRoutineKey());
    }
}
