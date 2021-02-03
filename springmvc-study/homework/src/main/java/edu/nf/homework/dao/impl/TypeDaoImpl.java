package edu.nf.homework.dao.impl;

import edu.nf.homework.dao.AdminDao;
import edu.nf.homework.dao.TypeDao;
import edu.nf.homework.entity.Type;
import edu.nf.homework.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/14
 */
//@Repository("typeDao")
public class TypeDaoImpl implements TypeDao {
    @Override
    public void save(Type type) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            sqlSession.getMapper(TypeDao.class).save(type);
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public List<Type> getTypes() {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            return sqlSession.getMapper(TypeDao.class).getTypes();
        }catch (RuntimeException e){
            throw e;
        }
    }
}
