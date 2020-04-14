package org.zhouhy.springboot.validate.validator;

import org.zhouhy.springboot.validate.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final Pattern PHONE_PATTERN
            = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");

    private static final Pattern PHONE_PATTERN1
            = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[/^]{8,16}$");
    @Override
    public void initialize(Password constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value == null || value.length() == 0 ) {
            return false;
        }
        Matcher m = PHONE_PATTERN.matcher(value);
        return m.matches();
    }
}
