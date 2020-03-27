package org.zhouhy.springboot.exception.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class MyException extends RuntimeException{
    private String code;


    public MyException(String code,String msg){
        super(msg);
        this.code = code;

    }
}
