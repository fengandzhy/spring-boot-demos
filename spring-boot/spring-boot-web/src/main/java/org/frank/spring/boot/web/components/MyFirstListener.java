package org.frank.spring.boot.web.components;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyFirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyFirstListener 监听到 ServletContext 初始化");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyFirstListener 监听到 ServletContext 销毁");
    }
}
