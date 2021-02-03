package edu.nf.ch15.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author 天文学
 * @date 2020/12/8
 * 定义切面
 */
public class UserServiceAspect implements MethodBeforeAdvice, AfterReturningAdvice,
        MethodInterceptor, ThrowsAdvice {
    /**
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕通知前。。。。");
        Object returnVal=invocation.proceed();
        System.out.println("环绕通知后。。。。");
        return returnVal;
    }

    /**
     * 后置通知
     * @param o
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置通知...");
    }

    /**
     * 前置通知
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("前置通知。。。");
    }

    /**
     * 异常通知
     * @param e
     */
    public void afterThrowing(Exception e){
        System.out.println("异常通知，"+e.getMessage());
    }
}
