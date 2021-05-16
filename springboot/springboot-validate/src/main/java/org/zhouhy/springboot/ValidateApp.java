package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 在这个测试的时候原有dto里面的属性是Id, 传入的json字符串一定不是Id而是id, 设置成Id的话它无法接受到
 * 
 * */
@SpringBootApplication
public class ValidateApp {
    public static void main(String[] args) {
        SpringApplication.run(ValidateApp.class,args);
    }    
}

/**
 * {"Id":"3",
 * "username":"Abc123e",
 * "password":"123a&kaiK",
 * "email":"123@123.com",
 * "phone":"13817037652",
 * "idCard":620104198205011313,
 * "sex":1,
 * "deleted":0,
 * "updateTime":1631133967488,
 * "createTime":1611133967488
 * }
 * 
 * */

