package org.zhouhy.springboot.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MockController {


    @RequestMapping(value="/test/get",method = RequestMethod.GET)
    public String testGet(){
        log.info("In the get request");
        return "abc";
    }

    @ResponseBody
    @RequestMapping(value="/test/hello",method = RequestMethod.GET)
    public String testGet1(String name){
        log.info("In the get request");
        return "Hello "+name;
    }
}
