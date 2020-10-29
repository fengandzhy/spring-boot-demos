package org.zhouhy.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.mybatis.entity.User;
import org.zhouhy.springboot.service.UserService;

import java.util.Random;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/c",method = RequestMethod.GET)
    public void create(){
        for(int i=0;i<1000;i++){
            User user=new User();
            String temp="user"+i;
            user.setUsername(temp);
            user.setPassword(temp);
            Random random=new Random();
            int sex=random.nextInt(2);
            user.setSex((byte)sex);
            userService.createUser(user);
        }
    }

    @RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
    public void updateById(@PathVariable int id){
        User user=new User();
        user.setId(id);
        String temp="update"+id;
        user.setUsername(temp);
        user.setPassword(temp);
        userService.updateUserById(user);
    }
}
