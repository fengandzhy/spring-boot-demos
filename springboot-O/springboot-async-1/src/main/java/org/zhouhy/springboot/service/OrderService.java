package org.zhouhy.springboot.service;

import org.springframework.web.context.request.async.DeferredResult;

public interface OrderService {

    DeferredResult<String> processOrder();
}
