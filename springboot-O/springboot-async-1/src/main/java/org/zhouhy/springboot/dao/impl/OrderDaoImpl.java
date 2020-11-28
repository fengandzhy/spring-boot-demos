package org.zhouhy.springboot.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.async.DeferredResult;
import org.zhouhy.springboot.component.DeferredResultHolder;
import org.zhouhy.springboot.component.queue.MockQueue;
import org.zhouhy.springboot.dao.OrderDao;
import org.zhouhy.springboot.entity.Order;

@Repository(value="orderDao")
@Slf4j
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private DeferredResultHolder holder;

    @Autowired
    private MockQueue mockQueue;

    private final static String ORDER="order_";

    @Override
    public DeferredResult<String> processOrder(Order order) {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        new Thread(()->{
            try {
                log.info("开始处理订单逻辑"+order.getOrderNumber());
                Thread.sleep(2000); //这里模拟处理订单的过程
                mockQueue.push(order.getOrderNumber()); // 将订单号传给 queue 
                holder.getHolder().put(order.getOrderNumber(),deferredResult); // 把deferredResult 暂时封存起来
                log.info("完成处理订单逻辑" + order.getOrderNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return deferredResult;
    }
}
