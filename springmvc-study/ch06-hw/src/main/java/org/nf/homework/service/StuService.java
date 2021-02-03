package org.nf.homework.service;

import org.nf.homework.entity.Student;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/6
 */
public interface StuService {

    /**
     * 查询学生列表
     * @return
     */
    List<Student> listStu();

    /**
     * 添加学生
     * @param s
     */
    void addStu(Student s);

    void delStu(int[] sids);
}
