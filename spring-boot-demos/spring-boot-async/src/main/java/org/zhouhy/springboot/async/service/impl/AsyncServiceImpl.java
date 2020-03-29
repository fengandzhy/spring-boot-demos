package org.zhouhy.springboot.async.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.async.service.AsyncService;

@Slf4j
@Service(value = "asyncService")
public class AsyncServiceImpl implements AsyncService {

    @Override
    public void register() {
        log.info("------------register user-----------");
    }

    @Async
    @Override
    public void credit() {
        try {
            Thread.sleep(5000);
            log.info("-----------------credit push--------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Async("redisPoolTaskExecutor")
    @Override
    public void redis() {
        try {
            Thread.sleep(2000);
            log.info("-----------------write into redis--------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("pushMsgPoolTaskExecutor")
    @Override
    public void pushMsg() {
        try {
            Thread.sleep(2000);
            log.info("-----------------push msg to user--------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
