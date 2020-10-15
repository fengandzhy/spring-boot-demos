package org.zhouhy.springboot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.annotation.Access;

@RestController
public class HelloController {

    @RequestMapping(value="/admin",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Access(authorities = {"admin"})
    public String hello(){
        return "hello,admin";
    }
}
