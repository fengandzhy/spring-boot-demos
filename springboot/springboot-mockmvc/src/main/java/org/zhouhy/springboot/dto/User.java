package org.zhouhy.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class User {
    
    public interface UserSimpleView{}
    public interface UserDetailView extends UserSimpleView{}
    
    
    private Integer Id;
    
    @JsonView(UserSimpleView.class)
    private String username;

    @JsonView(UserDetailView.class)
    private String password;
    private Integer age;
}
