package org.zhouhy.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.config.ConditionalOnPropertyUserConfig;
import org.zhouhy.springboot.service.OrderService;
import org.zhouhy.springboot.service.UserService;

@RestController
public class ConditionalOnPropertyController {
    
//    @Autowired
//    UserService userService;
//    
//    @Autowired
//    OrderService orderService;

    @Autowired
    private ApplicationContext applicationContext;
    
    @GetMapping("/")
    public String index(){
        UserService userService = null;
        try {
            userService = applicationContext.getBean(UserService.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        OrderService orderService = null;
        try {
            orderService = applicationContext.getBean(OrderService.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "userService=" + userService + "<br/>" +
                "orderService=" + orderService;
    }

//    @GetMapping("/names")
//    public String getBeanNames(){
//        ApplicationContext applicationContext 
//                = new AnnotationConfigApplicationContext(ConditionalOnPropertyUserConfig.class);
//        String[] names = applicationContext.getBeanDefinitionNames();
//        String result = "";
//        for (String name : names) {
//            System.out.println(">>>>>>" + name);
//            result=result+name+"<br/>";
//        }
//        return result;
//    }
//
//    @GetMapping("/names1")
//    public String getBeanNames1(){
//        String[] names = applicationContext.getBeanDefinitionNames();
//        String result = "";
//        for (String name : names) {
//            System.out.println(">>>>>>" + name);
//            result=result+name+"<br/>";
//        }
//        return result;
//    }
}
