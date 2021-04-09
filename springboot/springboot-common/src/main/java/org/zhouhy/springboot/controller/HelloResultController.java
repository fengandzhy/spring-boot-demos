package org.zhouhy.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.annotation.ResponseResultBody;
import org.zhouhy.springboot.entity.User;
import org.zhouhy.springboot.exception.ResultException;
import org.zhouhy.springboot.result.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/result")
@ResponseResultBody
public class HelloResultController {

    private static final HashMap<String, Object> INFO;

    static {
        INFO = new HashMap<>();
        INFO.put("name", "galaxy");
        INFO.put("age", "70");
    }
    
    @GetMapping("/string")
    public String stringResult(){
        return "hello world";
    }    

    @GetMapping(value = "/integer")
    public Integer integerResult() {
        return 123;
    }

    @GetMapping(value = "/map")
    public Map<String, Object> mapResult() {
        return INFO;
    }

    @GetMapping(value = "/list")
    public List<String> listResult() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        return list;
    }

    @GetMapping(value = "/object")
    public User objectResult() {
        User user = new User();
        user.setId(1);
        user.setName("A");
        user.setPassword("22334");
        return user;
    }
}
