package org.zhouhy.springboot.resource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 引入了themeleaf之后，在这个controller的帮助下会找到在templates下面的html文件
     * */
    @RequestMapping(value={"/","","/index"})
    public String index(){
        return "index";
    }
}
