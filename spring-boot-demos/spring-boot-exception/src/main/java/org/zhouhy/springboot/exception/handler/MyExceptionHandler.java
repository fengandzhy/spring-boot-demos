package org.zhouhy.springboot.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zhouhy.springboot.exception.exceptions.MyException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * @ExceptionHandler(value={Exception.class})
     * 这个value后面应该跟一个数组
     * 如果多配一个Handler，这里的Handler会比commons里面的handler更加优先执行
     *
     * */
//    @ResponseBody
//    @ExceptionHandler(value={Exception.class})
//    public Object handleException(Exception ex, HttpServletRequest request){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", 100);
//        map.put("msg", ex.getMessage());
//        map.put("url", request.getRequestURL());
//        return map;
//    }
//
//
//    @ExceptionHandler(value={MyException.class})
//    public ModelAndView handleMyException(Exception ex, HttpServletRequest request){
//        System.out.println(ex.getMessage());
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error.html");
//        modelAndView.addObject("msg", ex.getMessage());
//        return modelAndView;
//    }
}
