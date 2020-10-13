package org.zhouhy.springboot.advice.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.zhouhy.springboot.reponse.ErrorBean;
import org.zhouhy.springboot.reponse.ResponseBean;
import org.zhouhy.springboot.utils.JsonUtil;


/**
 * @ControllerAdvice 这是一个非常有用的注解，它的作用是增强Controller的扩展功能类。
 * 那@ControllerAdvice对Controller增强了哪些扩展功能呢？主要体现在2方面：
 *
 * 对Controller全局数据统一处理，例如，我们这节课就是对response统一封装。
 * 对Controller全局异常统一处理，这个后面的课程会详细讲解。
 *
 * 这个继承了ResponseBodyAdvice的类,并且这个类是要由这个注解@ControllerAdvice,会在response发送前统一处理,所以用这个类来做这个统一的返回格式是再好不过了
 * 具体的做法就是ResponseBean 来封装返回的格式, 而ResultEnum 告诉了你各种返回的结果
 * 所以主要就三个要素，第一继承了ResponseBodyAdvice的和有@ControllerAdvice注解的类,
 * 第二用于封装返回结果的ResponseBean 第三就是包含各种结果的ResultEnum
 * @RestControllerAdvice注解包含了@ControllerAdvice注解和@ResponseBody注解。
 *
 *
 *
 * */
@ControllerAdvice(basePackages = "org.zhouhy.springboot")
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(body instanceof ErrorBean){
            ErrorBean errorBean = (ErrorBean)body;
            ResponseBean responseBean = new ResponseBean();
            responseBean.fail(errorBean.getCode(),errorBean.getMessage());
            return responseBean;
        }

        if (body instanceof String) {
            ResponseBean<String> bean = new ResponseBean<>();
            bean.success((String)body);
            return JsonUtil.object2Json(bean); // 如果进来的body是string类型的,这里是不能更改的,必须也是string类型出去,所以就有了JsonUtil.object2Json
        }
        ResponseBean<Object> bean = new ResponseBean<>();
        bean.success(body);
        return bean;
    }


}
