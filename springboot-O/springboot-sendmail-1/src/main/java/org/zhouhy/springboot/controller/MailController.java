package org.zhouhy.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @GetMapping("/")
    public void index() {
        System.out.println("I am here");
    }
}
