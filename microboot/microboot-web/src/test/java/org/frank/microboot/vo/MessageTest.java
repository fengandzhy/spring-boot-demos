package org.frank.microboot.vo;

import org.junit.jupiter.api.Test;

public class MessageTest {    
    
    @Test
    public void test(){
        Message message = new Message(); // 调用无参构造进行对象实例化
        message.setTitle("沐言科技"); // 自动生成setter方法
        message.setContent("www.yootk.com"); // 自动生成setter方法
        System.out.println(message); // 调用toString()输出
    }
}
