package edu.nf.ch09.dao.impl;

import edu.nf.ch09.dao.UserDao;
import edu.nf.ch09.entity.User;
import edu.nf.ch09.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            sqlSession.getMapper(UserDao.class).save(user);
//            System.out.println(10/0);
        }catch (RuntimeException e){
            throw e;
        }
    }
}
