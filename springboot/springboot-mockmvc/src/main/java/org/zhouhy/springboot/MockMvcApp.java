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
 * 5. 关于这个jsonpath 的东西可以参考 https://github.com/json-path/JsonPath
 * 
 * 6. 关于这个@JsonView, 如果一个controller上多了一个@JsonView这个属性, 那么它所能返回的只能是这个@JsonView 在Javabean上标注的属性
 * 例如在这个User的password上标注了@JsonView(UserDetailView.class), 而在controller的findUserById1上标注了@JsonView(User.UserDetailView.class)
 * 那么这个findUserById1返回的user 里面的 json 字段只有 username 和 password. 有username的原因是因为在User里面username的属性
 * 被标注为@JsonView(UserSimpleView.class) 而 UserDetailView extends UserSimpleView
 * 
 * 
 * 
 *  
 * 
 * */
@SpringBootApplication
public class MockMvcApp {
    public static void main(String[] args) {
        SpringApplication.run(MockMvcApp.class,args);
    }
}
