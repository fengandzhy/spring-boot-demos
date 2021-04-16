package org.zhouhy.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.entity.User;

@RestController
public class IndexController {
    
    @RequestMapping("/user")
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("ABC");
        user.setPassword("BCD");
        return user;
    }
}
