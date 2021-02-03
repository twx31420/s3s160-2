package org.nf.spring.core;

import org.nf.spring.util.ScanUtil;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 天文学
 * @date 2020/12/3
 */
public class BeanFactory {

    /**
     * 存放bean描述
     */
    final Map<String,BeanDef> beanDefMap=new ConcurrentHashMap<>();

    /**
     * 存放单列实例bean
     */
    final Map<String,Object> singletoMap=new ConcurrentHashMap<>();

    public BeanFactory(String path) {
        Set<String> classNames= ScanUtil.scan(path);
        initBeanBefMap(classNames);
        initSingleto();
    }

    /**
     * 初始化所有类信息
     * @param classNames
     */
    private void initBeanBefMap(Set<String> classNames){
        for (String className:classNames){
            try {
                Class<?> beanClazz=getBeanClass(className);
                if (beanClazz.isAnnotationPresent(CSRID.class)){
                    String id=beanClazz.getAnnotation(CSRID.class).id();
                    String scope=beanClazz.getAnnotation(CSRID.class).scope();
                    String[] wired=beanClazz.getAnnotation(CSRID.class).wired();
                    Method init=beanClazz.getAnnotation(CSRID.class).init().isEmpty()?null:
                            beanClazz.getMethod(beanClazz.getAnnotation(CSRID.class).init());
                    Method destory=beanClazz.getAnnotation(CSRID.class).destory().isEmpty()?null:
                            beanClazz.getMethod(beanClazz.getAnnotation(CSRID.class).destory());
                    if (beanDefMap.containsKey(id)){
                        throw new RuntimeException("conflicts with existing, non-compatible bean definition of same name and class ["
                                + id + "]");
                    }else {
                        beanDefMap.put(id,createBeanDef(beanClazz,scope,wired,init,destory));
                    }
                }
            } catch (Exception e) {
                //throw new RuntimeException("method get error");
                e.printStackTrace();
            }

        }

    }

    /**
     * 获取类对象
     * @param className
     * @return
     */
    private Class<?> getBeanClass(String className){
        try {
           return Class.forName(className);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException("Can not find the class name "+className+"to build");
        }
    }

    /**
     * 创建beandef对象
     * @param bean
     * @param scope
     * @param wired
     * @param init
     * @param destory
     * @return
     */
    private BeanDef createBeanDef(Class<?> bean,String scope,String [] wired,Method init,Method destory){
        BeanDef beanDef=new BeanDef(bean,scope,wired,init,destory);
        return beanDef;
    }

    /**
     * 初始化单列对象
     */
    private void initSingleto(){
        for (String beanName:beanDefMap.keySet()){
            BeanDef beanDef=beanDefMap.get(beanName);
            if ("singleton".equals(beanDef.getScope())) {
                Object bean = newInstance(beanDef);
                singletoMap.put(beanName,bean);
            }
        }
    }

    /**
     * 创建实例
     * @param beanDef
     * @return
     */
    private Object newInstance(BeanDef beanDef){
        try {
            Object obj= beanDef.getBeanClass().newInstance();
            if (beanDef.getInit()!=null){
                beanDef.getInit().invoke(obj);
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Create bean instance fail.", e);
        }
    }

    /**
     * 获取bean实例
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        return doGetBean(beanName);
    }

    /**
     * 获取bean实例(泛型)
     *
     * @param beanName
     * @param clazz
     * @return
     */
    public <T> T getBean(String beanName, Class<T> clazz) {
        return (T) doGetBean(beanName);
    }

    /**
     * 从容器中获取Bean的BeanDefinition
     * 如果Bean的BeanDefinition的scope为singleton,则从singletonMap中获取单例
     * 否则以原型的方式创建并返回
     */
    private Object doGetBean(String beanName) {
        BeanDef beanDef = beanDefMap.get(beanName);
        if("singleton".equals(beanDef.getScope())){
            return singletoMap.get(beanName);
        }
        return newInstance(beanDef);
    }


}
