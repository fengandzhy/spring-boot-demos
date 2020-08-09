package org.zhouhy.springboot.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zhouhy.springboot.enums.ResultEnum;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseBean<T> {

    private Integer status;

    private String desc;

    private T data;

    public void success(T data){
        this.setResultCode(ResultEnum.SUCCESS);
        this.setData(data);
    }

    public void fail(Integer status,String desc){
        this.setStatus(status);
        this.setDesc(desc);
    }

    private void setResultCode(ResultEnum result){
        this.setStatus(result.getCode());
        this.setDesc(result.getMessage());
    }
}
