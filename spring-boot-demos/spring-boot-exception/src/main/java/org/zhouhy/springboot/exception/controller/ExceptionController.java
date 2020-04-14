package org.zhouhy.springboot.exception.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zhouhy.springboot.commons.eums.ResultCode;
import org.zhouhy.springboot.commons.exception.BusinessException;
import org.zhouhy.springboot.exception.exceptions.MyException;

@Api(description = "用户接口")
@RestController
public class ExceptionController {


    @RequestMapping(value="/test/exception",method=RequestMethod.GET)
    public void exceptionOccur(){
        int a = 1/0;
    }

    @RequestMapping(value="/test/myexception",method=RequestMethod.GET)
    public void excep(){
        throw new MyException(100,"error");
    }

    @PostMapping(value="/error4")
    public void  error4(  ){
        throw new RuntimeException("用户名已存在");
    }

    @PostMapping(value="/error3")
    public void  error3(  ){
        throw new BusinessException(ResultCode.USER_HAS_EXISTED);
    }
}
