package org.zhouhy.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.service.PayService;

@RestController
public class PayController {
    
    private final PayService payService;
    
    public PayController(PayService payService){
        this.payService = payService;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public void create(){
        this.payService.pay(1,2,10);
    }
}
