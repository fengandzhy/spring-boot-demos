package org.zhouhy.springboot.exception;

import lombok.Getter;
import org.zhouhy.springboot.enums.ResultStatus;

@Getter
public class ResultException extends RuntimeException{

    ResultStatus resultStatus;

    public ResultException(){
        this(ResultStatus.BAD_REQUEST);
    }

    public ResultException(ResultStatus status){
        super(status.getMessage());
        this.resultStatus = status;
    }
}
