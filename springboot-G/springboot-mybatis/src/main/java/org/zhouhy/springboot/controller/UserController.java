package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhouhy.springboot.mybatis.entity.User;
import org.zhouhy.springboot.service.UserService;

import java.util.List;
import java.util.Random;

@Slf4j
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

    @RequestMapping(value="/find/{id}",method = RequestMethod.GET)
    public void findUser(@PathVariable int id){
        User user = this.userService.findUser(100);
        log.info(user.toString());
    }

    @RequestMapping(value="/find",method = RequestMethod.GET)
    public void findUserBySex(@RequestParam byte sex){
        List<User> users = this.userService.findUser(sex);
        log.info("查到的个数是，{}",users.size());
    }

    @RequestMapping(value="/findex",method = RequestMethod.GET)
    public void findUsers(){
        List<User> users = this.userService.findUserByExample();
        log.info("查到的个数是，{}",users.size());
    }

    @RequestMapping(value="/findli",method = RequestMethod.GET)
    public void findUsersLike(){
        List<User> users = this.userService.findUserLike();
        log.info("查到的个数是，{}",users.size());
        log.info(users.toString());
    }

    @RequestMapping(value="/findin",method = RequestMethod.GET)
    public void findUsersIn(){
        List<User> users = this.userService.findUserIn();
        log.info("查到的个数是，{}",users.size());
        log.info(users.toString());
    }

    @RequestMapping(value="/findpage/{offset}/{size}",method = RequestMethod.GET)
    public void findUserspage(@PathVariable int offset,@PathVariable int size){
        List<User> users = this.userService.findUserPage1(offset,size);
        log.info("查到的个数是，{}",users.size());
        for(User user:users){
            log.info(user.toString());
        }

        users = this.userService.findUserPage2(offset,size);
        log.info("查到的个数是，{}",users.size());
        for(User user:users){
            log.info(user.toString());
        }
    }
}
