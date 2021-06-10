package org.zhouhy.springboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
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

    @JsonView(User.UserSimpleView.class)
    @RequestMapping(value="/user/{id:\\d+}",method = RequestMethod.GET)
    public User findUserById (@PathVariable(name="id") Integer Id){
        //{"username":"Abc","password":"123","age":3,"id":2}
        return createUser(Id);
    }

    @JsonView(User.UserDetailView.class)
    @RequestMapping(value="/user1/{id:\\d+}",method = RequestMethod.GET)
    public User findUserById1 (@PathVariable(name="id") Integer Id){
        return createUser(Id);
    }

    
    @RequestMapping(value="/user2/{id:\\d+}",method = RequestMethod.GET)
    public User findUserById2 (@PathVariable(name="id") Integer Id){
        return createUser(Id);
    }

    @PostMapping(value="/user")
    public User createUser (@RequestBody User user){
        System.out.println(user.toString());       
        return user;
    }
    
    private User createUser(Integer Id){
        User user = new User();
        
        user.setId(Id);
        user.setUsername("Abc");
        user.setPassword("123");
        user.setAge(3);
        return user;
    }
    
}
