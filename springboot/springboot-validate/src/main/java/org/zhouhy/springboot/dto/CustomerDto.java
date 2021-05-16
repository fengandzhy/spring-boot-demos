package org.zhouhy.springboot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDto {
    private Integer Id;
    private Date birthday;
}
