package org.zhouhy.springboot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component(value="ymlReader")
public class YmlReader {

    @Value("${mq.env}")
    private String env;

    @Value("${mq.env.diat}")
    private String diat;

    @Value("${mq.config.exchange}")
    private String exchange;

    @Value("${mq.config.queue.error}")
    private String error;
    
    @Value("${mq.config.queue.error.routing}")
    private String errorRoutine;

    @Value("${mq.config.queue.error.routing.key}")
    private String errorRoutineKey;

    @Value("${mq.config.queue.info}")
    private String info;
    
    @Value("${mq.config.queue.info.routing}")
    private String infoRoutine;

    @Value("${mq.config.queue.info.routing.key}")
    private String infoRoutineKey;
    
    
}
