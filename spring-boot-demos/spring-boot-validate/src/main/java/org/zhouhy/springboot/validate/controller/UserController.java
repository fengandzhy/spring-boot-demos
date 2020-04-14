package org.zhouhy.springboot.validate.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zhouhy.springboot.validate.vo.UserVO;


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



}
