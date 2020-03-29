package org.zhouhy.springboot.resp.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zhouhy.springboot.commons.response.Result;
import org.zhouhy.springboot.resp.entity.UserVO;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping(value="/user/create",produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    public void  crreteUser( @RequestBody @Validated UserVO userVO ){
        log.info("---------------crreteUser------------------");
    }

    @GetMapping(value="/getStr")
    public String  getStr(  ){
        return  "test";
    }

    @GetMapping(value="/getObject")
    public UserVO getObject(  ){
        UserVO vo=new UserVO();
        vo.setUsername("agan");
        return  vo;
    }

    @GetMapping(value="/empty")
    public void  empty(  ){

    }

    @GetMapping(value="/error")
    public void  error(  ){
        int i=9/0;
    }

    @GetMapping(value="/getResult")
    public Result getResult(  ){
        return Result.suc("test");
    }

}
