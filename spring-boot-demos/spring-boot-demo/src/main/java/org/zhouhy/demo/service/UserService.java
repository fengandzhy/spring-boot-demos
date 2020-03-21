package org.zhouhy.demo.service;

import org.zhouhy.demo.entity.User;

import java.util.List;


public interface UserService {

    public void saveUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);

    public User getOneUser(Integer id);

    public boolean login(User user);

    public List<User> findAllUsers();

    public List<User> findUserByUsernameLike(String username);
}
