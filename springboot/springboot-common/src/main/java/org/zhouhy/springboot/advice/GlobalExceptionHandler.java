package org.zhouhy.springboot.advice;


import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.WebResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;
import org.zhouhy.springboot.exception.ResultException;
import org.zhouhy.springboot.result.Result;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public final ResponseEntity<Result<?>> exceptionHandler(Exception ex, WebRequest request) {
        
        log.error("ExceptionHandler: {}", ex.getMessage());
        log.error("ExceptionHandler: {}", ex.getClass());
        
        return null;
    }
}


