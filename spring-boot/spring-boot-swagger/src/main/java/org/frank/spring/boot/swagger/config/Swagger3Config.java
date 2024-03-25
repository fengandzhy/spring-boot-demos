package org.frank.spring.boot.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class Swagger3Config {
    
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(createApiInfo());
    }
    
    @Bean
    public ApiInfo createApiInfo(){
        return new ApiInfo("Frank swagger",
                "Frank Api Documentation",
                "3.0",
                "http://localhost:8080",
                new Contact("Frank", "http://localhost:8080","frank@Frak.org"),
                "Apache 2.0",
                "https://www.apache.org/licences/LICENCES-2.0",
                new ArrayList<>());
    }
}
