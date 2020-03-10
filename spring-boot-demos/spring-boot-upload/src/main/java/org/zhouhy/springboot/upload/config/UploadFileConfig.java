package org.zhouhy.springboot.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class UploadFileConfig {

    @Value("${file.upload.location}")
    private String uploadFolder;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(uploadFolder);
        factory.setMaxFileSize(DataSize.ofKilobytes(1024*5));
        factory.setMaxRequestSize(DataSize.ofKilobytes(1024*20));
        return factory.createMultipartConfig();
    }
}
