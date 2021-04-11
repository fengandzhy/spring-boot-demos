package org.zhouhy.springboot.advice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.zhouhy.springboot.annotation.ResponseResultBody;
import org.zhouhy.springboot.result.Result;
import org.zhouhy.springboot.util.JsonUtil;

import java.lang.annotation.Annotation;


@Slf4j
@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseResultBody.class;
    
    //判断类或者方法是否使用了 @ResponseResultBody
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        log.info(AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(),ANNOTATION_TYPE)+"");
//        log.info(returnType.hasMethodAnnotation(ANNOTATION_TYPE)+"");
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(),ANNOTATION_TYPE)
                || returnType.hasMethodAnnotation(ANNOTATION_TYPE);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            return body;
        }
        // 这里唯独String是个例外, 如果进来的body是string类型的,这里是不能更改的,必须也是string类型出去,所以就有了JsonUtil.object2Json
        if(body instanceof String){
            return JsonUtil.object2Json(Result.success(body));
        }
        return Result.success(body);
    }    
}
