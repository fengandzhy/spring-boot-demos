package org.zhouhy.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.annotation.ResponseResultBody;

@RestController
public class IndexController {
    
    @ResponseResultBody
    @RequestMapping("/index")
    public String index(){
        //int a = 1/0; //这里故意营造一个异常, 如果这里抛异常了程序就不经过ResponseHandler了
        return "index";
    }
    
    @RequestMapping("/welcome")
    //@ResponseStatus(value = HttpStatus.ACCEPTED, reason = "Java的异常")
    public String welcome(){
        //int a = 1/0;
        return "welcome";
    }

    @PostMapping("/welcome2")    
    public String welcome2(){        
        return "welcome2";
    }
}
