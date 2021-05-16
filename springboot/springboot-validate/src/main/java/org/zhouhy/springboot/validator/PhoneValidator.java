package org.zhouhy.springboot.validator;

import org.zhouhy.springboot.annotation.Phone;
import org.zhouhy.springboot.util.ValidateUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone,String> {

    private static final String PHONE_PATTERN = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidateUtil.validate(value,PHONE_PATTERN);
    }
}
