package org.zhouhy.springboot.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {

    //默认为空
    String[] value() default {};
    String[] authorities() default{};
    String[] roles() default {};
}
