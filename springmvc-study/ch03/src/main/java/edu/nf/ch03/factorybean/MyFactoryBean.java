package edu.nf.ch03.factorybean;

import edu.nf.ch03.dao.UserDao;
import edu.nf.ch03.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 天文学
 * @date 2020/12/31
 */
public class MyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> dao;

    public MyFactoryBean() {
    }

    public MyFactoryBean(Class<T> dao) {
        this.dao = dao;
    }

    @Override
    public T getObject() throws Exception {
        return MybatisUtils.getSqlSession(true).getMapper(dao);
    }

    @Override
    public Class<?> getObjectType() {
        return dao;
    }


    @Override
    public boolean isSingleton() {
        return false;
    }
}
