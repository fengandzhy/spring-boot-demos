package org.zhouhy.springboot.async.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.async.service.AsyncService;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping(value="/async1",method=RequestMethod.GET)
    public String asyncTest1(){
        asyncService.register();
        asyncService.credit();
        return "Ok";
    }

    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String asyncTest2(){
        asyncService.register();
        asyncService.redis();
        asyncService.pushMsg();
        return "Ok";
    }
}
