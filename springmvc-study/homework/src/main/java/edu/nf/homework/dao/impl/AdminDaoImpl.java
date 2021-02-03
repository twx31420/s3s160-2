package edu.nf.homework.dao.impl;

import edu.nf.homework.dao.AdminDao;
import edu.nf.homework.entity.Admin;
import edu.nf.homework.factorybean.MyFatoryBean;
import edu.nf.homework.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * @author 天文学
 * @date 2021/1/14
 */
//@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin login(Admin admin) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            return sqlSession.getMapper(AdminDao.class).login(admin);
        }catch (RuntimeException e){
            throw e;
        }
    }
}
