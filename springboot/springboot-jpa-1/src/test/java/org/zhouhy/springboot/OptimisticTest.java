package org.zhouhy.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OptimisticTest {
    
    @Autowired
    private TestRestTemplate template;
    
    @Test
    public void inventoryTest(){
        String url = "http://localhost:8088/create_order";
        for(int i=0;i<100;i++){
           int finalI = i;
           new Thread(()->{               
               MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
               template.postForObject(url,params,String.class);
           }).start();
        }        
    }
}
