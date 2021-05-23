package org.zhouhy.springboot;

/**
 * Convention Over Configuration
 * 1. 关于maven 的scope, scope元素的作用：控制 dependency 元素的使用范围。通俗的讲，就是控制 Jar 包在哪些范围被加载和使用。 
 *  1) compile(默认) 被依赖项目需要参与到当前项目的编译，测试，打包，运行等阶段。打包的时候通常会包含被依赖项目. 
 *  2) provided 被依赖项目理论上可以参与编译、测试、运行等阶段，相当于compile，但是再打包阶段做了exclude的动作. 
 *  3) runtime 表示被依赖项目无需参与项目的编译，但是会参与到项目的测试和运行。与compile相比，被依赖项目无需参与项目的编译.
 *  4) test 表示被依赖项目仅仅参与测试相关的工作，包括测试代码的编译，执行。
 *  5) system system 元素与 provided 元素类似，但是被依赖项不会从 maven 仓库中查找，而是从本地系统中获取，systemPath 元素用于制定本地系统中 jar 文件的路径
 * 
 * 2. 关于mybatis 自动生成代码的步骤有这么以下几步
 *  1) 创建表users
 *  2) 修改pom文件, 加入依赖和一个插件
 *  3) 加入config.properties 和 generatorConfig.xml 文件, 其中config.properties文件里主要是数据库信息和package.name
 *  而generatorConfig.xml 这里面需要改的地方仅仅是最后的表名
 *  4) 双击 mybatis-generator:generate
 * 
 * 
 * 
 * 
 * */
public class MyBatisApp1 {
    public static void main(String[] args) {
        
    }
}
