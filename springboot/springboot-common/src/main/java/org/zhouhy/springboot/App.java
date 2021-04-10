package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1.统一格式的JSON返回数据分成以下几步
 *  1) 状态码枚举类
 *  2) 定义返回实体类
 *  3) 定义这个实现了ResponseBodyAdvice 接口的类
 *  
 * 2. 在这个实现了ResponseBodyAdvice 接口的类(ResponseHandler)当中加上 @RestControllerAdvice 或者 @ControllerAdvice
 * 才能实现返回结果的统一
 * 
 * 3. 在这个实现了ResponseBodyAdvice 接口的类中有个方法叫做supports, 用来判断什么样的controller 什么样的方法才能适用于这个统一的返回结果
 * 在本例中就是添加了@ResponseResultBody 注解的方法或者controller. 例如在本例中HelloResultController上面有注解@ResponseResultBody 
 * 那么其下的所有方法都会适用统一返回值. 而IndexController中的其中一个方法有@ResponseResultBody 而另外一个方法没有, 那么另外一个方法就不适用
 * 
 * 4. 如果某个方法添加了@ResponseResultBody (例如本例IndexController中的index), 但是这个方法在运行的过程中抛出异常了, 它就不会跑到
 * ResponseHandler这个类里面去了, 因为它尽管有了@ResponseResultBody注解, 本例的support 返回的都是false. 得需要专门的异常处理来做
 * 
 * 5. @RestControllerAdvice 或者 @ControllerAdvice 和这个@ExceptionHandler 一起联用就是异常处理信息的, 也就是说当一个类被标记为@RestControllerAdvice 或者 @ControllerAdvice 后
 * 那么它里面的@ExceptionHandler 就是用来处理异常的, 那么究竟能处理什么样的异常, 这个是根据@ExceptionHandler 异常类型来定义的
 * @RestControllerAdvice 或者 @ControllerAdvice 默认的是给所有controller中被 @RequestMapping注解的方法, 
 * 所以在本例中凡是被@RequestMapping标记过的方法抛异常都会由GlobalExceptionHandler来处理
 * 
 * 6. 在一个正常的controller方法上加上这个@ResponseStatus(value = HttpStatus.ACCEPTED, reason = "Java的异常"), 例如本例中的welcome方法
 * 如果这个方法本身不抛异常, 那么访问到这个方法时永远都会是@ResponseStatus 标记的结果. 也就是说在本例中当请求来到welcome时, 只要welcome方法
 * 没有抛出异常, 返回给前端的永远都是 HttpStatus.ACCEPTED 和 "Java的异常"
 * 
 * 
 * 
 * 
 * 
 * 
 * */

@SpringBootApplication
public class App {
    
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
