package org.zhouhy.springboot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.properties.SecurityProperties;
import org.zhouhy.springboot.properties.TestProperties;
import org.zhouhy.springboot.properties.UserProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {


    //要成功注入这个属性必须要有一个地方有@EnableConfigurationProperties
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserProperties userProperties;

    @Autowired
    private TestProperties testProperties;

    @Test
    public void test1() {
        System.out.println(securityProperties);
    }

    @Test
    public void test2() {
        System.out.println(securityProperties.getName());
    }

    @Test
    public void test3() {
        System.out.println(securityProperties.getBrowser().getLoginPage());
    }

    @Test
    public void test4() {
        System.out.println(userProperties);
    }

    @Test
    public void test5() {
        System.out.println(testProperties.getCode().getImage().getHeight());
    }

    @Test
    public void test6() {
        System.out.println(securityProperties.getCode().getImage().getHeight());
    }


}
