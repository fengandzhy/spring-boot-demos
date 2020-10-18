package org.zhouhy.springboot.async.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.zhouhy.springboot.async.async.DeferredResultHolder;
import org.zhouhy.springboot.async.async.MockQueue;
import org.zhouhy.springboot.async.async.service.OrderService;


@Slf4j
@RestController
public class AsyncController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value="/order")
    public DeferredResult<String> order(){
        log.info("主线程开始");

        DeferredResult<String> result = orderService.order();

        log.info("主线程结束");
        return result;
    }
}
