package org.zhouhy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhouhy.demo.dao.UserDao;
import org.zhouhy.demo.entity.User;
import org.zhouhy.demo.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public void updateUser(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public User getOneUser(Integer id) {
        return userDao.getOne(id);
    }

    @Override
    public boolean login(User user) {
        String username = user.getUsername();
        User u = userDao.getUserByUsername(username);
        if (u == null || !user.getPassword().equals(u.getPassword())){
            return false;
        }
        return true;
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public List<User> findUserByUsernameLike(String username) {
        return userDao.getUsersByUsernameLike(username);
    }
}
