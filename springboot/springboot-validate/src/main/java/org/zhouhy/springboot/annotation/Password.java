package org.zhouhy.springboot.annotation;

import org.zhouhy.springboot.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
public @interface Password {

    String message() default "请输入正确的密码,至少8-16个字符，至少1个大写字母，1个小写字母和1个数字";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Password[] value();
    }
}
