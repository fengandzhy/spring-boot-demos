package org.zhouhy.springboot.enums;

public enum ResultEnum {

    SUCCESS(200,"SUCCESS"),
    INTERNAL_ERROR(500,"INTERNAL_ERROR"),
    AUTHORIZATION_ERROR(2000,"authorization error"),
    USER_EXITS(2001,"user dose not exists"),
    BY_ZERO(2003,"/ by zero"),
    UNKNOWN_ERROR(2002,"UNKNOWN_ERROR");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResultEnum getResultByMessage(String message){
        for(ResultEnum r:ResultEnum.values()){
            if(r.getMessage().equals(message)){
                return r;
            }
        }
        return UNKNOWN_ERROR;
    }
}
