package org.zhouhy.springboot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.service.AsyncService;

@Slf4j
@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {
    @Override
    public void register() {
        log.info("register....");
    }

    @Override
    @Async("redisTaskExecutor")
    public void redis() {
        log.info("redis begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("redis end");
    }

    @Override
    @Async("creditTaskExecutor")
    public void credit() {
        log.info("credit begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("credit end");
    }

    @Override
    @Async("msgTaskExecutor")
    public void sendMsg() {
        log.info("sendMsg begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("sendMsg end");
    }
}
