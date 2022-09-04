package org.zhouhy.spring.boot.paramters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.zhouhy.spring.boot.paramters.dtos.UserDto;

@RestController
public class ParamController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("/no-param")
    public String noPram(){
        return "ok";
    }

    /**
     *  @RequestParam 这里可以省略，当@RequestParam 省略时默认的方法的参数名就是请求的参数名
     *  http://localhost:8080/request-param?username=321
     *  
     * */
    @GetMapping("/request-param")
    public String requestPram1(String username){        
        return username;
    }

    /**
     * @PathVariable 这里是不能省略的, 否则就读取不到了
     * 
     * */
    @GetMapping("/path-param/{username}")
    public String pathPram2(@PathVariable(name="username",required = false) String username){
        return username;
    }
    
    
    
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
