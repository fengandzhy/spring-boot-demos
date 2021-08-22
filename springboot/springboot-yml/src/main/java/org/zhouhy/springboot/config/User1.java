package org.zhouhy.springboot.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;


@Data
@ToString
@ConfigurationProperties(prefix = "user")
public class User1 {
    private int id;
    private String username;
    private String password;
    private Date birthday;
    private boolean sex;
    private List<String> list = new ArrayList<>();
    private Map<String,Object> map = new HashMap<>();
    private Address address;
}
