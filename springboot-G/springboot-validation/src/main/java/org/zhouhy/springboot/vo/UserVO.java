package org.zhouhy.springboot.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.zhouhy.springboot.annotation.Password;
import org.zhouhy.springboot.annotation.Phone;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class UserVO {

    private Integer Id;

    @NotEmpty(message = "用户名不能为空")
    @Length(min=6,max=12,message="用户名长度必须位于6到12之间")
    private String username;

    @Password
    private String password;

    @Email(message="请输入正确的邮箱")
    private String email;

    @Phone
    private String phone;

    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    @NotEmpty
    private String idCard;

    private Byte sex;
    private Byte deleted;
    @Future
    private Date updateTime;
    @Past
    private Date createTime;
}
