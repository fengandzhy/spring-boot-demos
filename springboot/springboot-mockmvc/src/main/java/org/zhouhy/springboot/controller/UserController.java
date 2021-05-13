package org.zhouhy.springboot.controller;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.dto.User;
import org.zhouhy.springboot.dto.UserSearchCondition;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    
    @RequestMapping(value="/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @RequestMapping(value="/user",method = RequestMethod.GET)
    public User findUserByUsername (@RequestParam(name="username") String username){
        User user = new User();
        user.setUsername(username);
        return user;
    }


    @RequestMapping(value="/user1",method = RequestMethod.GET)
    public List<User> findUserByCondition (UserSearchCondition condition){        
        System.out.println(ReflectionToStringBuilder.toString(condition,ToStringStyle.MULTI_LINE_STYLE));        
        List<User> users = new ArrayList<>();
        users.add(new User());        
        return users;
    }

    @RequestMapping(value="/user2",method = RequestMethod.GET)
    public List<User> findUserByConditionAndPageable (UserSearchCondition condition,
                                                      @PageableDefault(page=2,size=17,sort="username,desc") Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(condition,ToStringStyle.MULTI_LINE_STYLE));
        
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        
        List<User> users = new ArrayList<>();
        users.add(new User());
        return users;
    }
}
