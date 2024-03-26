package org.frank.spring.boot.validate.validator;

import org.zhouhy.springboot.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone,String> {

    private static final String PHONE_PATTERN = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if ( value == null || value.length() == 0 ) {
            return true;
        }
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(value);
        return  matcher.matches();
    }
}
