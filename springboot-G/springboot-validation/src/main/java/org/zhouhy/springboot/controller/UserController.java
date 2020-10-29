package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.vo.UserVO;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value="/user")
@Slf4j
public class UserController {

    @RequestMapping(value="/create",consumes = APPLICATION_JSON_UTF8_VALUE)
    public void createUser(@RequestBody @Validated UserVO userVO){
        log.info("creating a user....");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("done");
    }

    @RequestMapping(value="/update",consumes = APPLICATION_JSON_UTF8_VALUE)
    public void updateUser(String userId){
        UserVO userVO = this.getUserById(userId);
        Assert.notNull(userVO,"用户为空");
    }

    private UserVO getUserById(String userId){
        return null;
    }
}
