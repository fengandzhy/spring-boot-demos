package org.zhouhy.springboot.validator;


import org.zhouhy.springboot.annotation.Password;
import org.zhouhy.springboot.util.ValidateUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password,String> {

    private static final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidateUtil.validate(value,PASSWORD_PATTERN);
    }
}
