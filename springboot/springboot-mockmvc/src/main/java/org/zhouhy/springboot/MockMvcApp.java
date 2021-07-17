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
 * 请注意在controller上的createUser 和 findUserByCondition, 他俩都是一个javabean作为参数的不同的是createUser 有一个@RequestBody
 * 它的作用是把一个json的字符串转成对应的javabean. 而findUserByCondition它接受的只是request里面的参数
 * 
 * 3. 当你的controller的方法里有Pageable参数的时候, 你必须要穿三个参数size,page,sort, 如果你没有传参数它的默认值是
 * size=20, page=0,sort=UNSORTED
 * 
 * 4. 你可以用这种方式来设置Pageable的默认参数@PageableDefault(page=2,size=17,sort="username,desc")
 * 关于这个分页查询 
 * 1)在controller中制造一个Pageable  Pageable pageable = new PageRequest(pageNum - 1, pageSize, Sort.Direction.ASC, "id");
 * 2) 然后service返回的是一个 pageList Page<User> pageList = userService.findById(id, pageable);
 * 3) 然后在从pageList取出 dataList List<User> dataList = pageList.getContent();
 * 
 * 
 * 5. 关于这个jsonpath 的东西可以参考 https://github.com/json-path/JsonPath
 * 
 * 6. 关于这个@JsonView, 如果一个controller上多了一个@JsonView这个属性, 那么它所能返回的只能是这个@JsonView 在Javabean上标注的属性
 * 例如在这个User的password上标注了@JsonView(UserDetailView.class), 而在controller的findUserById1上标注了@JsonView(User.UserDetailView.class)
 * 那么这个findUserById1返回的user 里面的 json 字段只有 username 和 password. 有username的原因是因为在User里面username的属性
 * 被标注为@JsonView(UserSimpleView.class) 而 UserDetailView extends UserSimpleView
 * 
 * 7. 关于这个@RequestBody 它所起的作用就是当后台传上来一个类似于json的字符串时, 将其转换成为一个JavaBean对象
 * 
 * 8. 关于这个时间的输入, 假设在User字段上有个Date类型的属性,在你不需要转换器的时候输入的是date.getTime()
 * 就是说要输入的是一个long型的数据, 从1970年1月1日起的秒数.
 * 
 * 9. 在输出的时候是这样的, 如果springboot的是以前的版本1.5 左右的, 不用做特殊处理直接输入的话, 就是一个long型的数据
 * 从1970年1月1日起的秒数. 但是springboot 的版本如果是2.0 之后的, 直接输出就不会是这个long型数据了. 要得到这个long型的
 * 数据就需要做一个转换, 在application.properties里加入 spring.jackson.serialization.write-dates-as-timestamps=true
 * 
 * 10. 如果输出数据要得到其他的格式的spring.jackson.date-format 和 spring.jackson.time-zone
 *  
 * 11. 如果你要知道你所在的时区是哪个, 如下代码可知.
 * Calendar cal = Calendar.getInstance();
 * TimeZone timeZone = cal.getTimeZone();
 * System.out.println(timeZone.getID());
 * 
 * 
 * 13. 如果设置了spring.jackson.date-format 和 spring.jackson.time-zone 那么传入的值也会受到影响. 
 * 在以前的springboot中 默认的输入是时间戳, 默认的输出也是时间戳. 现在的springboot里可以输入的yyyy-mm-dd格式的数据
 * 作为日期, 输出类似于'2017-07-13T00:00:00.000+0000' 如果spring.jackson.date-format定义成了 yyyy-MM-dd HH:mm:ss
 * 那么输入可以是时间戳以及yyyy-MM-dd HH:mm:ss 原先的默认yyyy-mm-dd已经不好使了. 
 * 
 * 12. restcontroller 会自动转成json, 但是如果加入了jackson-jaxrs-xml-provider依赖, 它就会把返回结果转成xml文件的格式
 * 
 * 13, 如果你加入了jackson-jaxrs-xml-provider依赖并且仍然想返回json格式东西, 在@RequestMapping 里加上produces = {"application/json;charset=UTF-8"}
 * 
 * 
 * */
@SpringBootApplication
public class MockMvcApp {
    public static void main(String[] args) {
        SpringApplication.run(MockMvcApp.class,args);
    }
}
