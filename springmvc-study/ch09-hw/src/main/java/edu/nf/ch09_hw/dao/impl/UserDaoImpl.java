package edu.nf.ch09_hw.dao.impl;

import edu.nf.ch09_hw.dao.UserDao;
import edu.nf.ch09_hw.entity.User;
import edu.nf.ch09_hw.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User login(User user) {
        try(SqlSession sqlSession = MyBatisUtils.getSqlSession(true)){
            return sqlSession.getMapper(UserDao.class).login(user);
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public void save(User user) {
        try(SqlSession sqlSession = MyBatisUtils.getSqlSession(true)){
            sqlSession.getMapper(UserDao.class).save(user);
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public List<User> getList() {
        try(SqlSession sqlSession = MyBatisUtils.getSqlSession(true)){
           return sqlSession.getMapper(UserDao.class).getList();
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public void update(User user) {
        try(SqlSession sqlSession = MyBatisUtils.getSqlSession(true)){
            sqlSession.getMapper(UserDao.class).update(user);
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession sqlSession = MyBatisUtils.getSqlSession(true)){
            sqlSession.getMapper(UserDao.class).delete(id);
        }catch (RuntimeException e){
            throw e;
        }
    }
}
