package org.zhouhy.springboot.web.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Slf4j
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("The application is initializing");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
