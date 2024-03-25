package org.frank.spring.boot.swagger.controller;

import io.swagger.annotations.*;
import org.frank.spring.boot.swagger.entity.User;
import org.springframework.web.bind.annotation.*;

@Api(tags="hello类测试")
@RestController
public class HelloController {
    
    @ApiOperation("测试方法")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/search")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="姓名",required = true,paramType = "query"),
            @ApiImplicitParam(name="age",value="年龄",required = true,paramType = "query",dataType = "Integer")
    })
    @ApiOperation("test search")
    public String search(String name, Integer age){
        return name + ":" + age;
    }
    
    @PostMapping("/create")
    @ApiOperation("test create")
    public String createUser(User user){
        return user.toString();
    }
    
    @GetMapping("/user/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="编号",required = true,paramType = "path")            
    })
    @ApiResponses({
            @ApiResponse(code=408, message = "指定业务报错信息,返回客户端"),
            @ApiResponse(code=400, message = "请求参数没填好"),
            @ApiResponse(code=404, message = "请求路径不存在")
    })
    public User loadById(@PathVariable("id") Integer id){
        return new User(1,"a",12);
    }
}
