package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.dto.UserDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Slf4j
@RestController
@RequestMapping(value="/user")
public class UserController {

    @PostMapping(value="/create",consumes = APPLICATION_JSON_UTF8_VALUE)
    public void createUser(@RequestBody @Validated UserDto userDto){
        log.info("creating a user....");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("done");
    }
}
