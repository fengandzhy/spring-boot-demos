package org.zhouhy.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.service.OrderService;

@RestController
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    
    @PostMapping(value="/create_order")
    public String createOrder(){
        orderService.createOder();
        return "success";
    }
}
