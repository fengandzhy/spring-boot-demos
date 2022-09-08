package org.zhouhy.spring.boot.paramters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.zhouhy.spring.boot.paramters.dtos.UserDto;

import java.util.Arrays;

@RestController
public class ParamController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("/no-param")
    public String noPram(){
        return "ok";
    }

    /**
     *  @RequestParam 这里可以省略，当@RequestParam 省略时默认的方法的参数名就是请求的参数名
     *  http://localhost:8080/request-param1?username=321
     *  
     * */
    @GetMapping("/request-param1")
    public String requestPram1(String username){        
        return username;
    }

    /**
     *  @RequestParam 这里可以指定参数名, 当这里的参数名被制定 @RequestParam(name="username") 那方法里的参数名可以随意
     *  http://localhost:8080/request-param2?username=123&age=456
     *
     * */
    @GetMapping("/request-param2")
    public String requestPram2(@RequestParam(name="username") String name, 
                               @RequestParam(name="age") Integer age){
        return "name is "+name+", age is "+age;
    }

    /**
     *  @RequestParam 关于这个数组参数
     *  http://localhost:8080/request-param1?username=123&username=456
     *
     * */
    @GetMapping("/request-param3")
    public String requestPram3(@RequestParam(name="usernames") String[] name){                             
        return "name is "+ Arrays.toString(name);
    }   

    /**
     * @PathVariable 这里是不能省略的, 否则就读取不到了
     * 
     * */
    @GetMapping("/path-param/{username}")
    public String pathPram2(@PathVariable(name="username",required = false) String username){
        return username;
    }
    
    
    /**
     * 既可以用 form 表单的形式提交也可以用参数形式提交
     * http://localhost:8080/accept-user-from-param?id=2&name =eww&age=4&address=4322&pwd=123
     * */
    @RequestMapping(value="accept-user-from-param")
    public String acceptUserFromParam (@RequestParam UserDto dto){
        logger.info("at acceptUserFromParam method");
        logger.info(dto.toString());
        return "success";
    }

//    @RequestMapping(value="accept-user-from-json", consumes = {
//            "application/json"
//    })
    /**
     * 
     * */
    @RequestMapping(value="accept-user-from-json")
    public String acceptUserFromJson (@RequestBody UserDto dto){
        logger.info("at acceptUserFromJson method");
        logger.info(dto.toString());
        return "success";
    }

    @RequestMapping(value="accept-user-from-xml", consumes = {
            "application/xml"
    })
    public String acceptUserFromXml (@RequestBody UserDto dto){
        logger.info("at acceptUserFromJson method");
        logger.info(dto.toString());
        return "success";
    }
}
