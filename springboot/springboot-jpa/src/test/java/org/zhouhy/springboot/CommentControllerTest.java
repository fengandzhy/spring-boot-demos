package org.zhouhy.springboot;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.zhouhy.springboot.service.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Autowired
    private CommentService commentService;

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Test
    public void concurrentComment() {
        String url = "http://localhost:8080/comment";
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                params.add("articleId", "1");
                params.add("content", "测试内容" + finalI);
                String result = testRestTemplate.postForObject(url, params, String.class);
                System.out.println(result);
            }).start();
        }
    }

    @Test
    //10个线程 执行10次
    @PerfTest(invocations = 100,threads = 10)
    public void test() {

        commentService.postComment(1l,"Abc");

    }

}

