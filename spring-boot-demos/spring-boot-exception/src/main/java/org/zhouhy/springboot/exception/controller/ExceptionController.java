package org.zhouhy.springboot.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.zhouhy.springboot.exception.exceptions.MyException;

@Controller
public class ExceptionController {


    @RequestMapping(value="/test/exception",method=RequestMethod.GET)
    public void exceptionOccur(){
        int a = 1/0;
    }

    @RequestMapping(value="/test/myexception",method=RequestMethod.GET)
    public void excep(){
        throw new MyException("0001","error");
    }
}
