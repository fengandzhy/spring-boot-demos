package org.zhouhy.springboot.exceptions;

import lombok.Data;
import org.zhouhy.springboot.enums.ResultEnum;

@Data
public class MyRuntimeException extends RuntimeException{

    protected Integer code;

    protected String message;


    public MyRuntimeException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public MyRuntimeException(Integer code,String msg){

        this.code = code;
        this.message = msg;
    }
}
