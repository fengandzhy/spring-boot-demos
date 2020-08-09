package org.zhouhy.springboot.exceptions;

import lombok.Data;

@Data
public class MyException extends Exception{
    protected Integer code;

    protected String message;

    public MyException(Integer code,String msg){
        this.code = code;
        this.message = msg;
    }
}
