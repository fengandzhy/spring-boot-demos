package org.zhouhy.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.properties.SecurityProperties;

@RestController
public class AController {

    @Autowired
    private SecurityProperties securityProperties;

    @RequestMapping("/test")
    public void test(){
        System.out.println(securityProperties);
    }
}
