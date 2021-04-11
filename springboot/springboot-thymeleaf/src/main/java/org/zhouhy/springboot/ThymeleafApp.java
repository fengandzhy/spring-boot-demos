package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. thymeleaf 首先要要引入pom文件 spring-boot-starter-thymeleaf, 然后还要在页面中加入xmlns:th="http://www.thymeleaf.org"
 * 
 * 2. 由于配置了 context-path: /thymeleaf 所以在引用静态资源的时候 <link href="/thymeleaf/css/main.css" rel="stylesheet"> 
 *    得加上thymeleaf, 另外这个static本身就是默认的静态资源目录就不用写成/thymeleaf/static/css/main.css了.
 *    
 * 3. 当然你也可以换一种方法引用css, 把<link href="/thymeleaf/css/main.css" rel="stylesheet"> 换成 <link th:href="@{/css/main.css}" rel="stylesheet"> 
 *    注意不能写成link th:href="@{/thymeleaf/css/main.css}" 
 *    
 * 4. <div th:include="/view/fragments::pagination">1</div> 表示把当前标签里内容(也就是1)替换成模板标签里的内容
 * 
 * 5. <div th:replace="/view/fragments::pagination">2</div> 表示替换当前标签为模板中的标签
 *    
 * 6. <div th:insert="/view/fragments::pagination"> 在当前标签下插入模板标签   
 *    
 * 7. 关于传参数的请参考本例的demo2 demo3页面, 另外在demo3页面~{::title} 就是把demo3.html页面里面的title标签全部转到模板页面中去
 * 
 * 8. th:block：创建区域块（内容为空则不创建），之后th:block标签消失
 * 
 * 9. 参看demo4 brand.id是int型的而 category.content 是string型的, 所以通过这两个相等俩判断选中, 则是要brand.id+''
 * 
 * 
 *      
 * */
@SpringBootApplication
public class ThymeleafApp {
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApp.class,args);
    }
}
