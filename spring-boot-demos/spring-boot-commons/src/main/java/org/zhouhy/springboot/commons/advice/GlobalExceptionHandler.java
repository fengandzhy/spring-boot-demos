package org.zhouhy.springboot.commons.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zhouhy.springboot.commons.eums.ResultCode;
import org.zhouhy.springboot.commons.exception.BusinessException;
import org.zhouhy.springboot.commons.response.ErrorResult;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * @ResponseStatus 指定客户端收到的http状态码，这里配置500错误，客户端就显示500错误
     *
     * */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e, HttpServletRequest request){
        ResultCode code = ResultCode.getResultCodeByMessage(e.getMessage());
        ErrorResult error =ErrorResult.fail(code, e);
//        ErrorResult error =ErrorResult.fail(ResultCode.SYSTEM_ERROR, e);
        log.error("URL:{} ,系统异常: ",request.getRequestURI(), e);
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public ErrorResult handleMyException(BusinessException e, HttpServletRequest request){
        ErrorResult error = ErrorResult.builder().status(e.getCode())
                .message(e.getMessage())
                .exception(e.getClass().getName())
                .build();
        log.error("URL:{} ,系统异常: ",request.getRequestURI(), e);
        return error;
    }
}
