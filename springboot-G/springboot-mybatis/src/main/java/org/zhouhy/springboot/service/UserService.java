package org.zhouhy.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.mybatis.entity.User;
import org.zhouhy.springboot.mybatis.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

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

    public User findUser(Integer id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public List<User> findUser(byte sex){
        User user = new User();
        user.setSex(sex);
        List<User> users = userMapper.select(user);
        return users;
    }

    /**
     * 这里的username 和 password 与原本实体类的属性名称要一一对应 大小写也必须一致
     * */
    public List<User> findUserByExample(){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username","update100");
        criteria.andEqualTo("password","update100");
        List<User> users = this.userMapper.selectByExample(example);
        return users;
    }


    public List<User> findUserLike(){
        Example example = new Example(User.class);
        example.setOrderByClause("id desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("username","%100%");
        List<User> users = this.userMapper.selectByExample(example);
        return users;
    }

    public List<User> findUserIn(){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        criteria.andIn("id",ids);
        List<User> users = this.userMapper.selectByExample(example);
        return users;
    }

    /**
     * 这里的offset的意思是从第几个元素开始查
     * 比方说offset=8 就过滤掉前8个sex=1的元素从第九个开始显示
     * */
    public List<User> findUserPage1(int offset,int size){
        User user = new User();
        user.setSex((byte)1);
        int count = this.userMapper.selectCount(user);
        log.info("总条数,{}"+count);
        List<User> users = this.userMapper.selectByRowBounds(user,new RowBounds(offset,size));
        return  users;
    }

    /**
     * 这里的offset的意思是从第几个元素开始查
     * 比方说offset=8 就过滤掉前8个sex=1的元素从第九个开始显示
     * */
    public List<User> findUserPage2(int offset,int size){
        User user = new User();
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex",1);
        int count = this.userMapper.selectCountByExample(example);
        log.info("总条数,{}"+count);
        List<User> users = this.userMapper.selectByExampleAndRowBounds(example,new RowBounds(offset,size));
        return users;
    }
}
