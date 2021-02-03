package edu.nf.ch06_hw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 天文学
 * @date 2021/1/5
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer stuId;
    private String stuName;
    private Integer age;
    private ClassInfo classInfo;
}
