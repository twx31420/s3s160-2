package org.nf.homework.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.nf.homework.dao.ClassDao;
import org.nf.homework.entity.ClassInfo;
import org.nf.homework.util.MybatisUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@Repository
public class ClassDaoImpl implements ClassDao {
    @Override
    public List<ClassInfo> listClass() {
        try(SqlSession session= MybatisUtils.getSqlSession(true)){
            return session.getMapper(ClassDao.class).listClass();
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }
}
