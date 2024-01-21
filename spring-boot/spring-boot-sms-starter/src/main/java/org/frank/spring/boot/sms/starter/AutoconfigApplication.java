package org.frank.spring.boot.sms.starter;


import org.frank.spring.boot.start.AliyunSmsSenderImpl;
import org.frank.spring.boot.start.EnableSms;
import org.frank.spring.boot.start.TencentSmsSenderImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@EnableSms
@SpringBootApplication
public class AutoconfigApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AutoconfigApplication.class, args);
        AliyunSmsSenderImpl aliyunSmsSender = applicationContext.getBean(AliyunSmsSenderImpl.class);
        aliyunSmsSender.send("用阿里云发送短信");
        TencentSmsSenderImpl tencentSmsSender = applicationContext.getBean(TencentSmsSenderImpl.class);
        tencentSmsSender.send("用腾讯云发送短信");
    }
}
