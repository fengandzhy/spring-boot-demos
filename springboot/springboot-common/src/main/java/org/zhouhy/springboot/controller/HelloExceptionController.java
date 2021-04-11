package org.zhouhy.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.annotation.ResponseResultBody;
import org.zhouhy.springboot.exception.MyException;
import org.zhouhy.springboot.exception.ResultException;
import org.zhouhy.springboot.result.Result;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/exception")
@ResponseResultBody
public class HelloExceptionController {

    @GetMapping("/1")     
    public HashMap<String, Object> nullPointer() throws Exception {
        throw new NullPointerException("helloError");
    }

    @GetMapping("/2")
    public HashMap<String, Object> myException() throws Exception {
        throw new MyException(1001,"用户找不到");
    }

    @GetMapping("/3")
    public HashMap<String, Object> myRuntimeException() throws Exception {
        throw new MyException(1002,"程序运行时错误");
    }

    @GetMapping("/4")
    public HashMap<String, Object> runtimeException() throws Exception {
        int a = 1/0;
        return null;
    }

//    private static final HashMap<String, Object> INFO;
//
//    static {
//        INFO = new HashMap<String, Object>();
//        INFO.put("name", "galaxy");
//        INFO.put("age", "70");
//    }

//    @GetMapping("")
//    public HashMap<String, Object> helloError() throws Exception {
//        throw new Exception("helloError");
//    }
//

//
//    @GetMapping("helloMyError")
//    public HashMap<String, Object> helloMyError() throws Exception {
//        throw new ResultException();
//    }
//    @GetMapping("hello")
//    public HashMap<String, Object> hello() throws Exception{
//        throw new Exception("helloError");
//    }
//
//    @GetMapping("result")
//    public Result<Map<String, Object>> helloResult() {
//        return Result.success(INFO);
//    }
//
//    @GetMapping("helloError")
//    public HashMap<String, Object> helloError() throws Exception {
//        throw new Exception("helloError");
//    }
//
//    @GetMapping("helloMyError")
//    public HashMap<String, Object> helloMyError() throws Exception {
//        throw new ResultException();
//    }
//
//    @GetMapping(value = "testString")
//    public String testString() {
//        return "helloString";
//    }
//
//    @GetMapping(value = "testInt")
//    public Integer testInt() {
//        return 123;
//    }

}
