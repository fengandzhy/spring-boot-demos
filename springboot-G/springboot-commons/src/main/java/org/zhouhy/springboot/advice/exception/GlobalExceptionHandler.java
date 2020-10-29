package org.zhouhy.springboot.advice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zhouhy.springboot.enums.ResultEnum;
import org.zhouhy.springboot.exceptions.MyException;
import org.zhouhy.springboot.exceptions.MyRuntimeException;
import org.zhouhy.springboot.reponse.ErrorBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 统一处理异常有两个要点
 * 第一 要有@RestControllerAdvice 或者 @ControllerAdvice
 * 第二 在具体的方法上要有@ExceptionHandler 指定具体处理哪一类异常
 *
 * 但是在本例当中要返回统一格式, 那么首先在这里处理异常的时候就要有统一的格式,这样才在ResponseHandler里面更好的处理
 * 在这里就返回一个ErrorBean
 *
 *
 * */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * @ResponseStatus 指定客户端收到的http状态码，这里配置500错误，客户端就显示500错误
     *
     * */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorBean handleThrowable(Throwable e, HttpServletRequest request){
        return this.handleException(e,request);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //返回给客户端显示的状态码
    @ExceptionHandler(MyRuntimeException.class)
    public ErrorBean handleMyRuntimeException(MyRuntimeException e, HttpServletRequest request){
        return this.handleException(e,request);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //返回给客户端显示的状态码
    @ExceptionHandler(MyException.class)
    public ErrorBean handleMyException(MyException e, HttpServletRequest request){
        return this.handleException(e,request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) //返回给客户端显示的状态码
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorBean handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        String message = this.handle(e.getBindingResult().getFieldErrors());
        ErrorBean  errorBean = new ErrorBean(ResultEnum.PARAM_IS_INVALID,message);
        log.warn("URL:{} ,参数校验异常:{}", request.getRequestURI(),message);
        return errorBean;
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorBean handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
        ErrorBean  errorBean = new ErrorBean(ResultEnum.USER_EXITS,e.getMessage());
        log.warn("URL:{} ,参数校验异常:{}", request.getRequestURI(),e.getMessage());
        return errorBean;
    }

    private ErrorBean handleException(Throwable e,HttpServletRequest request){
        ErrorBean bean = new ErrorBean();
        log.info(e.getMessage());
        bean.setException(e);
        log.error("URL:{} ,系统异常: ",request.getRequestURI(), e);
        return bean;
    }

    private String handle(List<FieldError> fieldErrors) {
        StringBuilder sb = new StringBuilder();
        for (FieldError obj : fieldErrors) {
            sb.append(obj.getField());
            sb.append("=[");
            sb.append(obj.getDefaultMessage());
            sb.append("]  ");
        }
        return sb.toString();
    }
}
