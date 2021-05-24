package org.zhouhy.springboot;

/**
 * 1. 关于mybatis 自动生成代码的步骤有这么以下几步
 *  1) 创建表users
 *  2) 修改pom文件, 加入依赖和一个插件
 *  3) 加入config.properties 和 generatorConfig.xml 文件, 其中config.properties文件里主要是数据库信息和package.name
 *  而generatorConfig.xml 这里面需要改的地方仅仅是最后的表名
 *  4) 双击 mybatis-generator:generate
 *  
 * 2. 注意如果是mysql-connector-java 8.0 以上的版本的话, 要加上如下的属性, 才能保证正常运行, 否则它会把所有库里的users表都创建一遍 
 * <property name="nullCatalogMeansCurrent" value="true"/>
 * 
 * */
public class GeneratorApp {
    public static void main(String[] args) {
        
    }
}
