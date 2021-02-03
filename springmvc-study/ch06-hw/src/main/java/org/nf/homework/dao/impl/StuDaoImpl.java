package org.nf.homework.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.nf.homework.dao.StuDao;
import org.nf.homework.entity.Student;
import org.nf.homework.util.MybatisUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@Repository
public class StuDaoImpl implements StuDao {
    @Override
    public List<Student> listStu() {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            return sqlSession.getMapper(StuDao.class).listStu();
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void addStu(Student s) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
           sqlSession.getMapper(StuDao.class).addStu(s);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delStu(int[] sids) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            sqlSession.getMapper(StuDao.class).delStu(sids);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }
}
