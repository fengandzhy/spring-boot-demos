package org.zhouhy.springboot.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.*;


@ConfigurationProperties(prefix = "user")
@PropertySource(value = {"classpath:user.properties"})
@ToString
@Data
@Component
public class UserProperties {
    private int id;
    private String username;
    private String password;
    private Date birthday;
    private boolean sex;
    private List<String> list = new ArrayList<>();
    private Map<String,Object> map = new HashMap<>();
    private Address address;
}
