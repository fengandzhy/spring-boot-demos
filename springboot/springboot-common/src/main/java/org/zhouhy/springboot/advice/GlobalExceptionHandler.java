package org.zhouhy.springboot.advice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;
import org.zhouhy.springboot.enums.ResultStatus;
import org.zhouhy.springboot.exception.MyException;
import org.zhouhy.springboot.exception.MyRuntimeException;
import org.zhouhy.springboot.result.Result;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public final ResponseEntity<Result<?>> httpRequestMethodNotSupportedExceptionHandler(Exception ex, WebRequest request) {        
        log.error("HttpRequestMethodNotSupportedException: {} ", ex.getMessage());        
        Result<?> body = Result.failure(ResultStatus.METHOD_NOT_ALLOWED,ex.getLocalizedMessage());
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;        
        return this.handleExceptionInternal(ex,body,status,request);
    }

    @ExceptionHandler(MyException.class)
    public final ResponseEntity<Result<?>> myExceptionHandler(Exception ex, WebRequest request) {
        log.error("MyException: {} ", ex.getMessage());
        MyException myException = (MyException)ex; 
        Result<?> body = Result.failure(ResultStatus.BUSINESS_EXCEPTION1,myException.getCode()+" "+myException.getMessage());        
        return this.handleException(ex,body,request);
    }

    @ExceptionHandler(MyRuntimeException.class)
    public final ResponseEntity<Result<?>> myRuntimeExceptionHandler(Exception ex, WebRequest request) {
        log.error("MyRuntimeException: {} ", ex.getMessage());
        MyRuntimeException myRuntimeException = (MyRuntimeException)ex;
        Result<?> body = Result.failure(ResultStatus.BUSINESS_EXCEPTION2,myRuntimeException.getCode()+" "+myRuntimeException.getMessage());
        return this.handleException(ex,body,request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Result<?>> methodArgumentNotValidExceptionHandler(Exception ex, WebRequest request) {
        log.error("MyRuntimeException: {} ", ex.getMessage());
        MethodArgumentNotValidException myRuntimeException = (MethodArgumentNotValidException)ex;
        Result<?> body = Result.failure(ResultStatus.ARGUMENT_NOT_VALID,myRuntimeException.getMessage());
        return this.handleException(ex,body,request);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Result<?>> runtimeExceptionHandler(Exception ex, WebRequest request) {
        log.error("RuntimeException: {} ", ex.getMessage());        
        return this.handleException(ex,request);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Result<?>> exceptionHandler(Exception ex, WebRequest request) {
        log.error("Exception: {} ", ex.getClass());        
        return this.handleException(ex,request);
    }

    protected ResponseEntity<Result<?>> handleException(Exception ex,WebRequest request){
        Result<?> body = Result.failure(ResultStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
        return this.handleException(ex,body,request);
    }
    
    protected ResponseEntity<Result<?>> handleException(Exception ex,Result<?> body,WebRequest request){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return this.handleExceptionInternal(ex,body,status,request);
    }

    protected ResponseEntity<Result<?>> handleExceptionInternal(Exception ex, Result<?> body, HttpStatus status, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }    
}


