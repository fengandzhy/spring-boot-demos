package org.zhouhy.springboot.mybatis.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private Integer id;
    private String username;
    private String truename;

    public User(){

    }

    public User(Integer id,String username,String truename){
        this.id =id;
        this.username = username;
        this.truename = truename;
    }

}
