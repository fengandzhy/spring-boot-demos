package org.zhouhy.springboot.commons.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.zhouhy.springboot.commons.response.Result;
import org.zhouhy.springboot.commons.utils.JsonUtil;


/**
 * @ControllerAdvice 这是一个非常有用的注解，它的作用是增强Controller的扩展功能类。
 * 那@ControllerAdvice对Controller增强了哪些扩展功能呢？主要体现在2方面：
 *
 * 对Controller全局数据统一处理，例如，我们这节课就是对response统一封装。
 * 对Controller全局异常统一处理，这个后面的课程会详细讲解。
 * */
//@ControllerAdvice(basePackages = "org.zhouhy.springboot")
//public class ReponseHandler implements ResponseBodyAdvice<Object> {
//
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        if (body instanceof String) {
//            return JsonUtil.object2Json(Result.suc(body));
//        }
//        return Result.suc(body);
//        //return null;
//    }
//}
