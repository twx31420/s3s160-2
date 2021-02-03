package edu.nf.ch06_hw.service;

import edu.nf.ch06_hw.dao.StudentDao;
import edu.nf.ch06_hw.entity.Student;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/5
 */
public interface StudentService {
    List<Student> list();

    void add(Student stu);
}
