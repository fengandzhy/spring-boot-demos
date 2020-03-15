package org.zhouhy.springboot.mybatis.dao;

import org.zhouhy.springboot.mybatis.entity.User;

import java.util.List;

public interface UserDao {

    public User getUserById(Integer id);

    public List<User> getUsers();

    public void addUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);
}
