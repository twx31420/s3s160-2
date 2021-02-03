package edu.nf.ch06.entity;

import lombok.Data;

/**
 * @author 天文学
 * @date 2021/1/5
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
