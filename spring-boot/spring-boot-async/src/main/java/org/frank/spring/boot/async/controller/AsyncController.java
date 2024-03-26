package org.frank.spring.boot.async.controller;


import org.frank.spring.boot.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public String testAsync() {
        asyncService.asyncMethod();
        return "Async request received.";
    }
}
