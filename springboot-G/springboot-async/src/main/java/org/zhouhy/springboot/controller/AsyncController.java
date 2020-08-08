package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.service.AsyncService;

@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async1")
    public String asyncTask1(){
        asyncService.register();
        asyncService.credit();
        log.info("finish");
        return "Ok";
    }

    /**
     * 当主线程执行完asyncService.register(); 就会在三个不同的线程池中找三个线程分别异步执行下面的三个方法,然后主线程执行log.info("finish");
     * 这样一来，耗时的被异步执行了. 就提高了主线程的效率
     * */
    @GetMapping("/async2")
    public String asyncTask2(){
        asyncService.register();
        asyncService.credit();
        asyncService.redis();
        asyncService.sendMsg();
        log.info("finish");
        return "Ok";
    }
}
