package org.zhouhy.springboot.jpa.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyObjectMapper implements WebMvcConfigurer{

    @Bean
    public ObjectMapper myMapper() {
        ObjectMapper myObjectMapper = new ObjectMapper();
        myObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return myObjectMapper;
    }

}
