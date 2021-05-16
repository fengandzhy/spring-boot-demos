package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.service.AsyncService;

@Slf4j
@RestController
public class AsyncController {
    
    @Autowired
    private AsyncService asyncService;
    
    @GetMapping("/async")
    public String asyncTask(){
        log.info("Task begin");
        asyncService.register();
        asyncService.credit();
        asyncService.sendMsg();
        asyncService.redis();
        log.info("Task end");
        return "Ok";
    }
}
