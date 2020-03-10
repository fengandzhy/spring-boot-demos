package org.zhouhy.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 1. 配置servlet，写一个类MyServlet extends HttpServlet,然后在这个加上@WebServlet(urlPatterns = "/index.html")
 * 2. 在启动类上加上@ServletComponentScan
 *
 * 3. 另外一种方法配置servlet,写一个类AnotherServlet extends HttpServlet，
 * 4. 写一个配置类 ServletRegister 然后在这个配置类中写一个@Bean 返回的类型是 ServletRegistrationBean
 *
 * 5. 配置filter, 第一种方法也是要在启动类里面加入@ServletComponentScan 这个是为了扫描@WebFilter
 * 6. 写一个类MyFilter 实现Filter接口然后加上@WebFilter
 *
 * 7. 用另外一种方法配置filter也是一样，写一个注册类 返回 FilterRegistrationBean
 *
 * */
@SpringBootApplication
@ServletComponentScan
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
