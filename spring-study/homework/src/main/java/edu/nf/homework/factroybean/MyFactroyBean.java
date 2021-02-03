package edu.nf.homework.factroybean;

import edu.nf.homework.util.MybatisUtils;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 天文学
 * @date 2020/12/21
 */
public class MyFactroyBean<T> implements FactoryBean<T> {

    private Class<T> daoInterface;

    public void setDaoInterface(Class<T> daoInterface) {
        this.daoInterface = daoInterface;
    }

    @Override
    public T getObject() throws Exception {
        SqlSession sqlSession= MybatisUtils.getSqlSession(false);
        //daoInterface就是某个dao接口的class对象
        T mapperProxy=sqlSession.getMapper(daoInterface);
        return mapperProxy;
    }

    @Override
    public Class<?> getObjectType() {
        return daoInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
