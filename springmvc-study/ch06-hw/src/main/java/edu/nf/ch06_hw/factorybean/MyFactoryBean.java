package edu.nf.ch06_hw.factorybean;

import edu.nf.ch06_hw.util.MybatisUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author 天文学
 * @date 2021/1/5
 */
public class MyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> clazz;

    public MyFactoryBean(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T getObject() throws Exception {
        return (T)MybatisUtils.getSqlSession(true).getMapper(clazz);
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
