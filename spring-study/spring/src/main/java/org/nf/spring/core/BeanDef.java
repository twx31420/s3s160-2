package org.nf.spring.core;

import java.lang.reflect.Method;

/**
 * @author 天文学
 * @date 2020/12/3
 */
public class BeanDef {
    private Class<?> beanClass;
    private String scope;
    private String [] wired;
    private Method init;
    private Method destory;

    public BeanDef() {
    }

    public BeanDef(Class<?> beanClass, String scope, String[] wired, Method init, Method destory) {
        this.beanClass = beanClass;
        this.scope = scope;
        this.wired = wired;
        this.init = init;
        this.destory = destory;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String[] getWired() {
        return wired;
    }

    public void setWired(String[] wired) {
        this.wired = wired;
    }

    public Method getInit() {
        return init;
    }

    public void setInit(Method init) {
        this.init = init;
    }

    public Method getDestory() {
        return destory;
    }

    public void setDestory(Method destory) {
        this.destory = destory;
    }
}
