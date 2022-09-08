package org.zhouhy.spring.boot.paramters.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class User {
    
    public interface UserSimpleView{}
    public interface UserDetailView extends UserSimpleView{}
    
    
    private Integer Id;    
    @JsonView(UserSimpleView.class)
    private String username;
    @JsonView(UserDetailView.class)
    private String password;
    private Integer age;
    private Date date;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
