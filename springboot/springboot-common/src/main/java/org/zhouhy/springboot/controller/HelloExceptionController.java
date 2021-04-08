package org.zhouhy.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.annotation.ResponseResultBody;
import org.zhouhy.springboot.exception.ResultException;
import org.zhouhy.springboot.result.Result;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/error")
//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Java的异常")
@ResponseResultBody
public class HelloExceptionController {

    private static final HashMap<String, Object> INFO;

    static {
        INFO = new HashMap<String, Object>();
        INFO.put("name", "galaxy");
        INFO.put("age", "70");
    }

//    @GetMapping("")
//    public HashMap<String, Object> helloError() throws Exception {
//        throw new Exception("helloError");
//    }
//
//    @GetMapping("helloJavaError")
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Java的异常")    
//    public HashMap<String, Object> helloJavaError() throws Exception {
//        throw new Exception("helloError");
//    }
//
//    @GetMapping("helloMyError")
//    public HashMap<String, Object> helloMyError() throws Exception {
//        throw new ResultException();
//    }
    @GetMapping("hello")
    public HashMap<String, Object> hello() throws Exception{
        throw new Exception("helloError");
    }

    @GetMapping("result")
    public Result<Map<String, Object>> helloResult() {
        return Result.success(INFO);
    }

    @GetMapping("helloError")
    public HashMap<String, Object> helloError() throws Exception {
        throw new Exception("helloError");
    }

    @GetMapping("helloMyError")
    public HashMap<String, Object> helloMyError() throws Exception {
        throw new ResultException();
    }

    @GetMapping(value = "testString")
    public String testString() {
        return "helloString";
    }

    @GetMapping(value = "testInt")
    public Integer testInt() {
        return 123;
    }

}
