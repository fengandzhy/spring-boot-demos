package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.zhouhy.springboot.async.DeferredResultHolder;
import org.zhouhy.springboot.async.MockQueue;
import org.zhouhy.springboot.async.service.OrderService;

import java.util.concurrent.Callable;


@Slf4j
@RestController
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Autowired
    private OrderService orderService;

    @GetMapping(value="/order")
    public DeferredResult<String> order(){
        log.info("主线程开始");

        DeferredResult<String> result = orderService.order();

        log.info("主线程结束");
        return result;
    }

    @GetMapping(value="/order1")
    public Callable<String> order1(){
        log.info("主线程开始");

        //将业务逻辑的处理放到副线程中来
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("副线程开始");
                Thread.sleep(1000);
                log.info("副线程结束");
                return "success";
            }
        };
        log.info("主线程结束");
        return result;
    }

    @GetMapping(value="/order2")
    public DeferredResult<String> order2(){
        log.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);

        log.info("主线程结束");
        return result;
    }
}
