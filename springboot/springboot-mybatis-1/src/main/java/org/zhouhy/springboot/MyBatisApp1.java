package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Convention Over Configuration
 * 1. 关于maven 的scope, scope元素的作用：控制 dependency 元素的使用范围。通俗的讲，就是控制 Jar 包在哪些范围被加载和使用。 
 *  1) compile(默认) 被依赖项目需要参与到当前项目的编译，测试，打包，运行等阶段。打包的时候通常会包含被依赖项目. 
 *  2) provided 被依赖项目理论上可以参与编译、测试、运行等阶段，相当于compile，但是再打包阶段做了exclude的动作. 
 *  3) runtime 表示被依赖项目无需参与项目的编译，但是会参与到项目的测试和运行。与compile相比，被依赖项目无需参与项目的编译.
 *  4) test 表示被依赖项目仅仅参与测试相关的工作，包括测试代码的编译，执行。
 *  5) system system 元素与 provided 元素类似，但是被依赖项不会从 maven 仓库中查找，而是从本地系统中获取，systemPath 元素用于制定本地系统中 jar 文件的路径
 *  
 * 2. springboot 配置mybatis 的步骤
 *  1) pom 文件中加入依赖
 *  2) 修改application.properties文件, 具体的请参考本例
 *  3) 在启动类里加载@MapperScan("org.zhouhy.springboot.mapper")
 *  4) 编写各种entiry类和mapper接口和mappper xml文件
 * 
 * 
 * */
@SpringBootApplication
@MapperScan("org.zhouhy.springboot.mapper")
public class MyBatisApp1 {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisApp1.class,args);
    }
}
