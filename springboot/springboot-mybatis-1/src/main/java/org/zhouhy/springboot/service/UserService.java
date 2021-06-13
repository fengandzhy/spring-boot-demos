package org.zhouhy.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.entity.User;
import org.zhouhy.springboot.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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
        
        User u = this.userMapper.selectByPrimaryKey(100);
        System.out.println(u.toString());
        
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

        log.info("----------------Example.Criteria 模糊查询： where username like ? ----------------");
        example=new Example(User.class);
        criteria=example.createCriteria();
        criteria.andLike("username","%3%");
        users=this.userMapper.selectByExample(example);
        log.info("Example.Criteria查询结果，{}",users.toString());

        log.info("----------------Example.Criteria 排序： where username like ? order by id desc ----------------");
        example=new Example(User.class);
        example.setOrderByClause("id desc ");
        criteria=example.createCriteria();
        criteria.andLike("username","%3%");
        users=this.userMapper.selectByExample(example);
        log.info("Example.Criteria查询结果，{}",users.toString());

        log.info("----------------Example.Criteria in 查询： where id  in (1,2) ----------------");
        example=new Example(User.class);
        criteria=example.createCriteria();
        List ids=new ArrayList();
        ids.add(1);
        ids.add(2);
        criteria.andIn("id",ids);
        users=this.userMapper.selectByExample(example);
        log.info("Example.Criteria查询结果，{}",users.toString());

        log.info("----------------分页查询1----------------");
        User obj2=new User();
        obj2.setSex((byte)1);
        int count=this.userMapper.selectCount(obj2);
        log.info("分页例子：总条数{}",count);
        users=this.userMapper.selectByRowBounds(obj2,new RowBounds(0,10));
        for (User u:users){
            log.info("分页例子：第一页{}",u.toString());
        }

        log.info("----------------Example.Criteria分页查询2----------------");
        example=new Example(User.class);
        criteria=example.createCriteria();
        criteria.andEqualTo("sex",1);
        count=this.userMapper.selectCountByExample(example);
        log.info("分页例子：总条数{}",count);

        users=this.userMapper.selectByExampleAndRowBounds(example,new RowBounds(0,10));
        for (User u:users){
            log.info("分页例子：第一页{}",u.toString());
        }        
    }
}
