package org.zhouhy.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.zhouhy.springboot.entity.UserVO;

import java.util.Random;


@Api(description = "正常返回的用户接口")
@RestController
public class NormalReturnController {

    @RequestMapping(value="/success",method=RequestMethod.GET)
    public String success(){
        return "success";
    }

    @ApiOperation("修改某条数据")
    @GetMapping(value = "/u/{id}")
    public UserVO findUserById(@PathVariable int id){
        Random rand = new Random();
        UserVO user=new UserVO();
        user.setId(id);
        user.setUsername("temp01");
        user.setPassword("temp02");
        int n = rand.nextInt(2);
        user.setSex((byte)n);
        return user;
    }

}
