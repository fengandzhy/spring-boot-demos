package org.zhouhy.springboot.json.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.json.entity.User;

import java.util.Date;

@RestController
@RequestMapping(value="/json")
public class JsonController {

    @RequestMapping(value="/user",method = RequestMethod.GET)
    public Object getUser(){
        User user = new User();
        user.setAge(13);
        user.setPwd("123");
        //user.setPhone("132332");
        user.setCreateTime(new Date());
        return user;
    }
}
