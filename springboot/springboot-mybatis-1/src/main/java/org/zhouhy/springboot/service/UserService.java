package org.zhouhy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.entity.User;
import org.zhouhy.springboot.mapper.UserMapper;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public void create(User user){
        userMapper.insertSelective(user);
    }
}
