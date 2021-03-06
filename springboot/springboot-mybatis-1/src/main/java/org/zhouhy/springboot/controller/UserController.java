package org.zhouhy.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.entity.User;
import org.zhouhy.springboot.service.UserService;

import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/create")
    public void create(){
        for(int i=0;i<1000;i++){
            User user = new User();
            String temp = "user"+i;
            user.setUsername(temp);
            user.setPassword(temp);
            Random random = new Random();
            int gender = random.nextInt(2);
            user.setSex((byte)gender);
            user.setCreateTime(new Date());
            this.userService.create(user);
        }
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id){
        this.userService.update(id);
    }

    @GetMapping("/search")
    public void search(){
        this.userService.search();
    }

    @GetMapping("/search_by_example")
    public void searchByExample(){
        this.userService.searchByExample();
    }
    
    
}
