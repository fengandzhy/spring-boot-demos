package org.zhouhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. 注意本例用MockMvc来测试访问controller 
 *  1) 必须要注意注入WebApplicationContext
 *  2) 在@Before里面mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
 *  3) 注意各种访问以及结果的验证, 具体请看考本例的代码
 *  
 * 2. 如果controller的方法里是一个Javabean作为参数的时候, 不用写@ReqeustParam 只需要传参跟Javabean的属性对应上就行
 * 
 * 3. 当你的controller的方法里有Pageable参数的时候, 你必须要穿三个参数size,page,sort, 如果你没有传参数它的默认值是
 * size=20, page=0,sort=UNSORTED
 * 
 * 4. 你可以用这种方式来设置Pageable的默认参数@PageableDefault(page=2,size=17,sort="username,desc")
 * 
 * */
@SpringBootApplication
public class MockMvcApp {
    public static void main(String[] args) {
        SpringApplication.run(MockMvcApp.class,args);
    }
}
