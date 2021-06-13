package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyBean1.class})
public class MyConfig {
    
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}
