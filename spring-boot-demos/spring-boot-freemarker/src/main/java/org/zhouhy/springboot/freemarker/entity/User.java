package org.zhouhy.springboot.freemarker.entity;

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
    private String password;

    public User(){

    }

    public User(Integer id,String username,String password){
        this.id = id;
        this.username= username;
        this.password = password;
    }
}
