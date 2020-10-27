package org.zhouhy.springboot.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.zhouhy.springboot.enums.ResultEnum;

@AllArgsConstructor
@Data
@Slf4j
public class ErrorBean {

    private Integer code;
    private String message;

    public void setException(Throwable e){
        log.info(e.getLocalizedMessage());
        ResultEnum resultEnum = ResultEnum.getResultByMessage(e.getMessage());
        this.setInfo(resultEnum);
    }

    private void setInfo(ResultEnum resultEnum){
        this.setCode(resultEnum.getCode());
        this.setMessage(resultEnum.getMessage());
    }

    public ErrorBean(ResultEnum resultEnum,String message){
        this.setMessage(message);
        this.setCode(resultEnum.getCode());
    }

    public ErrorBean(){}
}
