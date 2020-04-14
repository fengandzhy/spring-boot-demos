package org.zhouhy.springboot.commons.exception;


import lombok.Data;
import org.zhouhy.springboot.commons.eums.ResultCode;

@Data
public class BusinessException extends RuntimeException{

    protected Integer code;

    protected String message;


    public BusinessException(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public BusinessException(Integer code,String msg){
        this.code = code;
        this.message = msg;
    }
}
