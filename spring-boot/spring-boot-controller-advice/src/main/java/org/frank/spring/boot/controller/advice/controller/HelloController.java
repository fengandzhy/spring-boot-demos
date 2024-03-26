package org.frank.spring.boot.controller.advice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(Model model){
        return (String)model.getAttribute("msg");
    }
}
