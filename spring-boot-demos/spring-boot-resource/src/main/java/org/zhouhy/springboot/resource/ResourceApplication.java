package org.zhouhy.springboot.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *  Spring Boot 默认会挨个从META-INF/resources > resources > static > public  里面找是否存在相应的资源，如果有则直接返回,
 *  例如在static下面放一个js文件，如果浏览器输入http://localhost:8080/test.js 可以直接返回,
 *  但是，如果在static下建立一个文件夹js 此时在浏览器里输入http://localhost:8080/js/test.js 就无法返回，必须引入themeleaf模板才可以正常返回
 *  但是，如果在application.properties里面加入一个自定义的资源文件夹，例如spring.resources.static-locations = classpath:/javascript/ 此时浏览器里输入http://localhost:8080/js/test1.js 就无效了
 *  因为就相当于把默认的资源文件集合给全部覆盖掉了，所以必须把所有的资源文件夹都加入进来 spring.resources.static-locations = classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/,classpath:/javascript/
 *
 *  生产环境下，静态资源文件存储在CDN
 * */
@SpringBootApplication
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class,args);
    }
}
