package org.frank.spring.boot.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
