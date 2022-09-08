package org.zhouhy.spring.boot.paramters.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private Integer Id;    
    private String username;    
    private String password;
    private Integer age;
    private Date date;    
}
