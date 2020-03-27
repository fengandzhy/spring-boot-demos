package org.zhouhy.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestApplication.class})
@AutoConfigureMockMvc
public class TestCase1 {

    @Autowired
    private MockMvc mockMvc;


    /**
     * .get("/test/get")).andExpect(MockMvcResultMatchers.status().isOk())
     * 这个的意思就是用get方式访问，并且访问的结果是200
     *
     *
     * */
    @Test
    public void test1() throws Exception{
        MvcResult mvcResult =  mockMvc.perform( MockMvcRequestBuilders
                .get("/test/get"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.content().string("abc"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
    }


    /**
     *.andExpect(MockMvcResultMatchers.content().string("Hello Frank"))
     * 这个内容的比较只有在是@ResponseBody的时候才起到效果
     *
     * */
    @Test
    public void test2() throws Exception{
        MvcResult mvcResult =  mockMvc.perform( MockMvcRequestBuilders
                .get("/test/hello")
                .param("name","Frank"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello Frank"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
    }
}
