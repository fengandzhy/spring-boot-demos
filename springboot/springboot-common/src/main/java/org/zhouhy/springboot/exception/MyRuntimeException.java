package org.zhouhy.springboot.exception;

public class MyRuntimeException extends RuntimeException{

    public Integer code;
    public String message;
    
    public MyRuntimeException(Integer code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
