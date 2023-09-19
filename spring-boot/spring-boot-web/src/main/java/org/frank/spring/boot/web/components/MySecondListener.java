package org.frank.spring.boot.web.components;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySecondListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MySecondListener 监听到 ServletContext 初始化");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MySecondListener 监听到 ServletContext 销毁");
    }
}
