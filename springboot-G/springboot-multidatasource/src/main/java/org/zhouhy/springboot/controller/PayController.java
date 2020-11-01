package org.zhouhy.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.service.PayService;

@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public void create(){
//        this.payService.pay(1,2,10);
        this.payService.payAccount(1,10);
    }
}
