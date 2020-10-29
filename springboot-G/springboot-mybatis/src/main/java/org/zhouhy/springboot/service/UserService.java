package org.zhouhy.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.mybatis.entity.User;
import org.zhouhy.springboot.mybatis.mapper.UserMapper;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createUser(User user){
        userMapper.insertSelective(user);
    }

    public void updateUserById(User user){
        userMapper.updateByPrimaryKey(user);
    }
}
