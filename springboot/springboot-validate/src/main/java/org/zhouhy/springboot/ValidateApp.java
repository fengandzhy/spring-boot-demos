package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 在这个测试的时候原有dto里面的属性是Id, 传入的json字符串一定不是Id而是id, 设置成Id的话它无法接受到
 * 
 * 2. 关于这个自定义验证的有这么几个步骤
 *  1) 创建声明例如@Password
 *  2) 实现自定义校验规则例如PasswordValidator
 *  3) 在这个UserDto里面标注
 *  
 * 3. 如果Dto里面还有一个Dto需要校验, 例如UserDto里面还有一个CustomerDto, 要让CustomerDto里面的校验规则在UserDto里面生效
 * 就必须加上@Valid
 * 
 * 4. 还有在controller里面如果传入的是一个UserDto类型的参数且这个参数需要校验, 一定要在方法的参数上加这个注解@Validated
 * 
 * 5. 如果要校验@RequestParam 和 @PathVariable 的时候,请参考本例中的CustomerController例子 注意要在controller 上加入@Validated 
 * 
 * 6. 如果要安排统一的异常处理需要以下几个步骤
 *  1) 加入springboot-common 依赖
 *  2) 加入注解@ResponseResultBody
 *  3) 修改GlobalExceptionHandler
 *  
 *  
 * */
@SpringBootApplication
public class ValidateApp {
    public static void main(String[] args) {
        SpringApplication.run(ValidateApp.class,args);
    }    
}

/**
 * {"Id":"3",
 * "username":"Abc123e",
 * "password":"123a&kaiK",
 * "email":"123@123.com",
 * "phone":"13817037652",
 * "idCard":620104198205011313,
 * "sex":1,
 * "deleted":0,
 * "updateTime":1631133967488,
 * "createTime":1611133967488,
 * "customerDto":{
 *     "id":1,
 *     "birthday":"2022-03-01"
 * }
 * }
 * 
 * */

