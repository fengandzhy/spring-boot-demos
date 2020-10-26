package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import org.zhouhy.springboot.service.OrderService;

@Controller
@RequestMapping(value="/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/process",method = RequestMethod.POST)
    @ResponseBody
    public DeferredResult<String> processOrder(){
        log.info("主程序开始");
        DeferredResult<String> result = orderService.processOrder();
        log.info("主程序结束");
        return result;
    }

}
