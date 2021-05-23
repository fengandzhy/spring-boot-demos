package org.zhouhy.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.entity.User;

import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/create")
    public void create(){
        for(int i=0;i<1000;i++){
            User user = new User();
            String temp = "user"+i;
            user.setUsername(temp);
            user.setPassword(temp);
            Random random = new Random();
            int gender = random.nextInt(2);
            
            
        }
    }
}
