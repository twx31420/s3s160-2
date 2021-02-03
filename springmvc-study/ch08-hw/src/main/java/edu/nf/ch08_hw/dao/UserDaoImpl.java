package edu.nf.ch08_hw.dao;

import edu.nf.ch08_hw.entity.User;
import edu.nf.ch08_hw.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 天文学
 * @date 2021/1/11
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        try(SqlSession sqlSession= MyBatisUtils.getSqlSession(true)){
            sqlSession.getMapper(UserDao.class).add(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
