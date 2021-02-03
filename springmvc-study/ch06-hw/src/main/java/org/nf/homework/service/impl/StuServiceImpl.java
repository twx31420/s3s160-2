package org.nf.homework.service.impl;

import org.nf.homework.dao.StuDao;
import org.nf.homework.entity.Student;
import org.nf.homework.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuDao stuDaoImpl;

    @Override
    public List<Student> listStu() {
        return stuDaoImpl.listStu();
    }

    @Override
    public void addStu(Student s) {
        stuDaoImpl.addStu(s);
    }

    @Override
    public void delStu(int[] sids) {
        stuDaoImpl.delStu(sids);
    }
}
