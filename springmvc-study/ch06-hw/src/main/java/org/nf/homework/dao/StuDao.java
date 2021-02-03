package org.nf.homework.dao;

import org.nf.homework.entity.Student;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/6
 */
public interface StuDao {
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

    /**
     * 批量删除
     * @param sid
     */
    void delStu(int[] sids);
}
