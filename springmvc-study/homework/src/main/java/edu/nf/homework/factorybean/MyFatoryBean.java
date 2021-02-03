package edu.nf.homework.factorybean;

import edu.nf.homework.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 天文学
 * @date 2021/1/14
 */
public class MyFatoryBean<T> implements FactoryBean<T> {

    private Class<T> clazz;

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T getObject() throws Exception {
        SqlSession sqlSession= MybatisUtils.getSqlSession(true);
        return sqlSession.getMapper(clazz);
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
