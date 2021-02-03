package edu.nf.ch06_hw.service.impl;

import edu.nf.ch06_hw.dao.StudentDao;
import edu.nf.ch06_hw.entity.Student;
import edu.nf.ch06_hw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/5
 */
@org.springframework.stereotype.Service("ser")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao dao;

    @Override
    public List<Student> list() {
        return dao.getList();
    }

    @Override
    public void add(Student stu) {
        dao.addStu(stu);
    }
}
