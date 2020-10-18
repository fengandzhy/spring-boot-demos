package org.zhouhy.springboot.async.async.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import org.zhouhy.springboot.async.async.DeferredResultHolder;
import org.zhouhy.springboot.async.async.MockQueue;

@Service
public class OrderService {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    public DeferredResult<String> order(){
        //随机生成一个8位的订单号
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        //模拟组成结果
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        deferredResultHolder.getMap().put(orderNumber,result);
        return result;
    }
}
