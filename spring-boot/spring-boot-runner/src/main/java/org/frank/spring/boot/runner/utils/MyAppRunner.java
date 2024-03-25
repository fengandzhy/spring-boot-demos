package org.frank.spring.boot.runner.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 在这里编写你的代码
        System.out.println("Hello from MyAppRunner");
    }
}
