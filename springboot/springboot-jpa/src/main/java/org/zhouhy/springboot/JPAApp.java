package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 关于ddl-auto 的几个值
 *  1) create: 每次加载hibernate时都会删除上一次的生成的表,然后根据你的model类再重新来生成新表,
 *  哪怕两次没有任何改变也要这样执行,这就是导致数据库表数据丢失的一个重要原因. *  
 *  2) create-drop: 每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除
 *  3) update: 最常用的属性,第一次加载hibernate时根据model类会自动建立起表的结构(前提是先建立好数据库),
 *  以后加载hibernate时根据 model类自动更新表结构,即使表结构改变了但表中的行仍然存在不会删除以前的行.
 *  4) validate: 每次加载hibernate时,验证创建数据库表结构,只会和数据库中的表进行比较,不会创建新表,但是会插入新值
 *  
 * 2. 
 * 
 * 
 * */
@SpringBootApplication
public class JPAApp {
    public static void main(String[] args) {
        SpringApplication.run(JPAApp.class,args);
    }
}
