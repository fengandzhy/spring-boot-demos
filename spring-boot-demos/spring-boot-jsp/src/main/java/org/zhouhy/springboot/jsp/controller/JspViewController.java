package org.zhouhy.springboot.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspViewController {

//    @RequestMapping(value={"/index","/",""},method = RequestMethod.GET)
//    public ModelAndView index(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }

    @RequestMapping(value={"/index","/",""},method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}