package org.zhouhy.springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.exceptions.MyException;
import org.zhouhy.springboot.exceptions.MyRuntimeException;
import org.zhouhy.springboot.service.ExceptionService;

@Api(description = "用户接口")
@RestController
public class ExceptionController {

    @Autowired
    private ExceptionService exceptionService;

    @RequestMapping(value="/test/exception",method=RequestMethod.GET)
    public void exceptionOccur(){
        int a = 1/0;
    }

    @RequestMapping(value="/service/exception",method=RequestMethod.GET)
    public void serviceException(){
        exceptionService.cal();
    }

    @RequestMapping(value="/my/exception1",method=RequestMethod.GET)
    public void myRuntimeException(){
        throw new MyRuntimeException(2001,"user dose not exists");
    }

    @RequestMapping(value="/my/exception2",method=RequestMethod.GET)
    public void myException() throws Exception{
        throw new MyException(2000,"authorization error");
    }
}
