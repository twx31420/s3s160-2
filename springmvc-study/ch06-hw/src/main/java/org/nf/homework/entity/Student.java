package org.nf.homework.entity;

import lombok.Data;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@Data
public class Student {

    private Integer sid;
    @NotEmpty(message = "{stu.name.NotEmpty}")
    private String stuName;
    @NotNull(message = "{stu.age.NotNull}")
    @Min(value=12,message = "{stu.age.min}")
    private Integer age;
    //多对一关联班级
    private ClassInfo cla;
}
