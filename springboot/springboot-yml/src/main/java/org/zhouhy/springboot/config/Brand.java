package org.zhouhy.springboot.config;

import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

@ToString
@Component
@ConfigurationProperties(prefix = "brand")
@PropertySource(value = {"classpath:brand.properties"})
public class Brand {
    private int id;
    private String name;
    private Double price;
    private Date birthday;    
    private List<String> list = new ArrayList<>();
    private Map<String,Object> map = new HashMap<>();
    
}
