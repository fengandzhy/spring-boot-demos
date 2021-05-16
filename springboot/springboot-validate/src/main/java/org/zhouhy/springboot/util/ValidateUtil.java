package org.zhouhy.springboot.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
    
    public static boolean validate(String value,String rule){
        if(null == value || value.length() ==0){
            return false;
        }
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    } 
}
