package org.zhouhy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class IndexController {
    
    
    public String index(Model model){
        
        
        
        return "index";
    }
}
