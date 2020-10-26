package org.zhouhy.springboot.dao;

import org.springframework.web.context.request.async.DeferredResult;
import org.zhouhy.springboot.entity.Order;

public interface OrderDao {

    DeferredResult<String> processOrder(Order order);
}
