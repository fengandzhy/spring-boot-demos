package org.frank.spring.boot.swagger.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api()
@RestController
public class HelloController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
