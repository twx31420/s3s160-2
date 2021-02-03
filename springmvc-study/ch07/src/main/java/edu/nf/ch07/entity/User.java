package edu.nf.ch07.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author 天文学
 * @date 2021/1/7
 * 使用bean验证，只需要在字段上使用相关的
 * 验证注解
 */
@Data
public class User {
//    @NotEmpty(message = "请输入用户名")
    @NotEmpty(message = "{user.userName.notEmpty}")
    private String userName;
    @NotNull(message = "{user.age.notNull}")
    @Min(value = 18,message = "{user.age.min}")
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{user.birth.notNull}")
    private Date birth;
    @NotNull(message = "{user.email.notEmpty}")
    @Email(message = "{user.email.legal}")
    @Pattern(regexp="\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}",message ="{user.email.legal}" )
    private String email;

//    @Pattern(regexp="正则表达式",message ="验证消息")
}
