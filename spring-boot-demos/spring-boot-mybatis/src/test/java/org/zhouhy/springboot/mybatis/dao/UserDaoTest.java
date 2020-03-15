package org.zhouhy.springboot.mybatis.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.mybatis.entity.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testDao(){
        log.info(userDao.getClass().toString());
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("zhouhy");
        user.setTruename("zhy");
        userDao.addUser(user);
    }

    @Test
    public void testGetUserById(){
        User user = userDao.getUserById(1);
        log.info(user.toString());
    }

    @Test
    public void testUpdateUser(){
        User user = userDao.getUserById(1);
        user.setTruename("zhouhongyuan");
        userDao.updateUser(user);
    }

    @Test
    public void testGetUsers(){
        List<User> users = userDao.getUsers();
        log.info(users.size()+"");
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(1);
    }
}
