package org.zhouhy.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.entity.User;
import org.zhouhy.springboot.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Slf4j
@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public void create(User user){
        userMapper.insertSelective(user);
    }
    
    public void update(Integer id){
        User user = userMapper.selectByPrimaryKey(id);
        String temp = "update_"+id;
        user.setUsername(temp);
        user.setPassword(temp);
        userMapper.updateByPrimaryKey(user);
    }

    public void search(){
        log.info("--------------------search where sex =1 -----------------------------");
        User user = new User();
        user.setSex((byte)1);
        List<User> users = this.userMapper.select(user);
        log.info("查询sex=1的条数,{}",users.size());

        log.info("--------------------search where username =? and password = ? -----------------------------");
        User user1 = new User();
        user1.setUsername("update_3");
        user1.setPassword("update_3");
        List<User> users1 = this.userMapper.select(user1);
        log.info("查询username=update_3 and password=update_3 的条数,{}",users1.size());
    }
    
    public void searchByExample(){
        log.info("--------------------search where username =? and password = ? -----------------------------");
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username","update_3");
        criteria.andEqualTo("password","update_3");
        List<User> users = this.userMapper.selectByExample(example);
        log.info("example 查询结果,{}",users.toString());
        
    }
}
