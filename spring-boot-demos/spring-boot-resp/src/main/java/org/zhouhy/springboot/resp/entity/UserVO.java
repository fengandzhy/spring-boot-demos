package org.zhouhy.springboot.resp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserVO {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String idCard;
    private Byte sex;
    private Byte deleted;
    private Date updateTime;
    private Date createTime;
}
