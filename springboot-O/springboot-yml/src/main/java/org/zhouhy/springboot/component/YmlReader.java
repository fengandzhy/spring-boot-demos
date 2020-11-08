package org.zhouhy.springboot.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component(value="ymlReader")
public class YmlReader {
    
    @Value("mq.config.exchange")
    private String exchange;

    @Value("mq.config.exchange.error")
    private String errorRoutine;

    @Value("mq.config.exchange.error.key")
    private String errorRoutineKey;

    @Value("mq.config.exchange.info")
    private String infoRoutine;

    @Value("mq.config.exchange.info.key")
    private String infoRoutineKey;
}
