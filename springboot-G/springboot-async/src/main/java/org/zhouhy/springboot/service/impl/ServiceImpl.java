package org.zhouhy.springboot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.service.AsyncService;

@Slf4j
@Service("asynService")
public class ServiceImpl implements AsyncService {

    @Override
    public void register() {
        log.info("register");
    }

    @Override
    @Async("redisTaskExecutor")
    public void redis() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("redis");
    }

    @Override
    @Async("creditTaskExecutor")
    public void credit() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("credit");
    }

    @Override
    @Async("msgTaskExecutor")
    public void sendMsg() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("sendMsg");
    }
}
