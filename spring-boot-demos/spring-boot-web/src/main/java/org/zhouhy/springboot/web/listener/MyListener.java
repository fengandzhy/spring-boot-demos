package org.zhouhy.springboot.web.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("系统初始化了。。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
