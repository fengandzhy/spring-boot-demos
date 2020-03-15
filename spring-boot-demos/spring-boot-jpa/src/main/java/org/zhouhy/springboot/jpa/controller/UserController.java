package org.zhouhy.springboot.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhouhy.springboot.jpa.dao.UserDao;
import org.zhouhy.springboot.jpa.entity.User;

import java.util.Date;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping(value="saveuser.html",method = RequestMethod.GET)
    public String saveUser(){
        User user = new User();
        user.setUsername("zhouhy");
        user.setPassword("123456");
        user.setRegisterDate(new Date());
        userDao.save(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value="find.html",method = RequestMethod.GET)
    public Object getUser(){
       User user = userDao.getOne(1);
//       User user1 = new User();
//       user1.setId(user.getId());
//       user1.setUsername(user.getUsername());
//       user1.setPassword(user.getPassword());
//       user1.setRegisterDate(user.getRegisterDate());
//       log.info(user.getUsername()+","+user.getPassword()+","+user.getRegisterDate());
//       return user1;
        return user;
    }
}
