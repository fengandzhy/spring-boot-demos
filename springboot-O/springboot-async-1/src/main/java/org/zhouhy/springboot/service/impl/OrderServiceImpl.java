package org.zhouhy.springboot.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import org.zhouhy.springboot.component.DeferredResultHolder;
import org.zhouhy.springboot.dao.OrderDao;
import org.zhouhy.springboot.entity.Order;
import org.zhouhy.springboot.service.OrderService;

@Service(value="orderSerVice")
public class OrderServiceImpl implements OrderService {    

    @Autowired
    private OrderDao orderDao;

    @Override
    public DeferredResult<String> processOrder(){
        Order order = new Order();
        String orderNumber = RandomStringUtils.randomNumeric(8);
        order.setOrderNumber(orderNumber);
        DeferredResult<String> deferredResult = orderDao.processOrder(order);
        return deferredResult;
    }
}
