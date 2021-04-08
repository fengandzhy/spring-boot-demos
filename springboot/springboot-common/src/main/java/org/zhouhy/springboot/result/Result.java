package org.zhouhy.springboot.result;

import lombok.Getter;
import lombok.ToString;
import org.zhouhy.springboot.enums.ResultStatus;


/**
 * 返回实体类
 * 
 * We define uniform return body in this class 
 * and in this class we will call the enum to get the return status code and message.
 * 
 * */
@Getter
@ToString
public class Result<T> {
    
    //业务错误码
    private Integer code;
    
    //信息描述
    private String message;
    
    //返回参数
    private T data;
    
    private Result(ResultStatus resultStatus,T data){
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.data = data;
    }
    
    public static Result<Void> success(){
        return new Result<Void>(ResultStatus.SUCCESS,null);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(ResultStatus.SUCCESS,data);
    }
    
    public static <T> Result<T> success(ResultStatus resultStatus,T data){
        if(resultStatus == null){
            return success(data);
        }
        return new Result<>(resultStatus,data);        
    }
    
    public static <T> Result<T> failure(){
        return new Result<>(ResultStatus.INTERNAL_SERVER_ERROR,null);
    }
    
    public static <T> Result<T> failure(ResultStatus resultStatus){
        return failure(resultStatus,null);
    }

    public static <T> Result<T> failure(ResultStatus resultStatus,T data){
        if(resultStatus == null){
            return new Result<>(ResultStatus.INTERNAL_SERVER_ERROR,null);
        }
        return new Result<T>(resultStatus,data);
    }
    
}
