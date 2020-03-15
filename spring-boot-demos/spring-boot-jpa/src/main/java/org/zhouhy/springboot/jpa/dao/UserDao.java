package org.zhouhy.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhouhy.springboot.jpa.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {
}
