package org.zhouhy.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mockMvc;
    
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    /**
     * 无参数
     * */
    @Test
    public void getUsersTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    /**
     * 有参数
     * */
    @Test
    public void findUserByUsernameTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username","jojo")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("jojo"));
    }


    @Test
    public void findUserByConditionTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user1")
                .param("username","jojo")
                .param("ageTo","85")
                .param("ageFrom","18")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
    }

    @Test
    public void findUserByConditionAndPageableTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user2")
                .param("username","jojo")
                .param("ageTo","85")
                .param("ageFrom","18")
//                .param("size","15")
//                .param("page","3")
//                .param("sort","age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
    }


    @Test
    public void findUserByIdTest() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/2")                
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())                
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void findUserByIdTest1() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user1/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void findUserByIdTest2() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user2/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
    
}
