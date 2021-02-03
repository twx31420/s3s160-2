package org.nf.project.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.nf.project.dao.UserDao;
import org.nf.project.entity.User;
import org.nf.project.util.MybatisUtils;
import org.springframework.stereotype.Repository;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            sqlSession.getMapper(UserDao.class).addUser(user);
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public User getUserById(int uid) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
           return sqlSession.getMapper(UserDao.class).getUserById(uid);
        }catch (RuntimeException e){
            throw e;
        }
    }
}
