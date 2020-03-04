package org.zhouhy.springboot.json.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User {

    private int age;

    /**
     * @JsonIgnore
     * 表示忽略
     * */
    @JsonIgnore
    private String pwd;


    /**
     * @JsonProperty("account") 表示把phone变成account，json里节点的名字改变
     * @JsonInclude(JsonInclude.Include.NON_NULL) 如果phone 是null 那么在返回的json里不会显示account:null，而是什么都不显示
     * */
    @JsonProperty("account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private Date createTime;

    public User(){

    }

    public User(Integer age,String pwd,String phone,Date createTime){
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }
}
