package edu.nf.ch06_hw.dao;

import edu.nf.ch06_hw.entity.Student;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/5
 */
public interface StudentDao {

    List<Student> getList();

    void addStu(Student stu);
}
