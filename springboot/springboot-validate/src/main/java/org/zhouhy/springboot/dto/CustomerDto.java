package org.zhouhy.springboot.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class CustomerDto {
    
    private Integer Id;

    @Length(min=6,max=12,message="客户名长度必须位于6到12之间")
    private String customerName;
    
    @Past
    private Date birthday;
}
