package org.zhouhy.spring.boot.paramters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.spring.boot.paramters.dtos.UserDto;

@RestController
public class ParamController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping(value="accept-user-from-param")
    public String acceptUserFromParam (UserDto dto){
        logger.info("at acceptUserFromParam method");
        logger.info(dto.toString());
        return "success";
    }

    @RequestMapping(value="accept-user-from-json")
    public String acceptUserFromJson (@RequestBody UserDto dto){
        logger.info("at acceptUserFromJson method");
        logger.info(dto.toString());
        return "success";
    }
}
