package org.zhouhy.springboot.exception.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.zhouhy.springboot.commons.exception.BusinessException;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class MyException extends BusinessException {



    public MyException(Integer code,String msg){
//        this.message = msg;
//        //super(msg);
//        this.code = code;
        super(code,msg);
    }
}
