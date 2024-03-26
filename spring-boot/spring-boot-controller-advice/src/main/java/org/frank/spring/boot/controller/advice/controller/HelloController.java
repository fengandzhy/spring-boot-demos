package org.frank.spring.boot.controller.advice.controller;

import org.frank.spring.boot.controller.advice.entity.Boy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(Model model){
        return (String)model.getAttribute("msg");
    }

    @PostMapping("/boy")
    public Boy hello(@RequestBody Boy boy){
        return boy;
    }
}
