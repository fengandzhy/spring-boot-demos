package org.zhouhy.springboot.service;

import org.springframework.stereotype.Service;

@Service("exceptionService")
public class ExceptionService {

    public void cal(){
        int a = 1/0;
    }
}
