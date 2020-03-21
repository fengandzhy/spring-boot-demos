package org.zhouhy.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhouhy.demo.entity.User;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {

    User getUserByUsername(String username);

    List<User> getUsersByUsernameLike(String username);
}
