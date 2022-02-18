package org.zhouhy.spring.boot.first.boot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    
    @RequestMapping("/echo")
    public String index(String msg){
        return "Hello Spring boot " + msg;
    }
}
