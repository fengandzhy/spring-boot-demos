package org.zhouhy.springboot.enums;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


/**
 * 状态码枚举类
 * We define all of the return status code and the relevant message in this enum class
 * 
 * */
@ToString
@Getter
public enum ResultStatus {
    
    SUCCESS(HttpStatus.OK,200,"OK"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,400,"Bad Request"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED,405,"Method not Allowed"),
    ARGUMENT_NOT_VALID(HttpStatus.INTERNAL_SERVER_ERROR,500,"Argument not valid!"),
    BUSINESS_EXCEPTION1(HttpStatus.INTERNAL_SERVER_ERROR,500,"Business Exception 1"),
    BUSINESS_EXCEPTION2(HttpStatus.INTERNAL_SERVER_ERROR,500,"Business Exception 2"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,500,"Internal Server Error");

    //返回的HTTP状态码,  符合http请求
    private HttpStatus httpStatus;

    //业务异常码
    private Integer code;

    //业务异常信息描述
    private String message;

    ResultStatus(HttpStatus httpStatus,Integer code,String message){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
    
    public static ResultStatus getResult(HttpStatus status){
        for(ResultStatus resultStatus:ResultStatus.values()){
            if(resultStatus.httpStatus == status){
                return  resultStatus;
            }
        }
        return null;
    }
}
