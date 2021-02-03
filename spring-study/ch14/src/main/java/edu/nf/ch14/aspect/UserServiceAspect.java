package edu.nf.ch14.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author 天文学
 * @date 2020/12/7
 * 定义一个切面，在这个类中声明需要增强的业务逻辑，
 * 在运行时将切面里面的增强逻辑应用到具体的目标对象上
 * （类似于回调处理器InvocationHandler）
 * 这个切面可以实现更多的接口来完成不同的增强
 *
 * Advice (通知/增强)
 * MethodBeforeAdvice,接口用于实现前置的通知，在调用目标方法前执行的逻辑
 *
 * AfterReturningAdvice,接口用于实现后置通知，在目标方法返回后执行的逻辑
 *
 * MethodInterceptor，接口用于实现环绕通知，在目标方法前后都执行的逻辑
 *
 * ThrowsAdvice,接口用于实现异常通知，在目标方法抛出异常后执行的逻辑
 */
public class UserServiceAspect implements MethodBeforeAdvice, AfterReturningAdvice,
        MethodInterceptor, ThrowsAdvice , AfterAdvice {

    /**
     * 前置通知
     * @param method 当前目标对象正在调用的方法
     * @param args 目标方法所需要的参数
     * @param target 目标对象（被代理对象）
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置通知");
    }

    /**
     * 后置通知(注意：如果产生了异常，则不会执行后置通知，因为没有正常返回是不会执行的)
     * @param returnValue 目标方法的返回值
     * @param method 当前目标对象正在调用的方法
     * @param args 标方法所需要的参数
     * @param target 目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置通知");
    }


    /**
     * 环绕通知，在目标方法前后都执行的逻辑
     * @param invocation 方法回调处理器，用于调用目标对象的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕通知前");
        Object returnVal=invocation.proceed();
        System.out.println("环绕通知后");
        return returnVal;
    }

    /**
     * 异常同，参照官方文档throwsAdvice
     * 该方法的名称必须叫做afterThrowing
     * 该方法还有是哪个可选参数（method args，target）
     * 则三个参数要么全部声明，要么全部省略
     * 但exception参数必须保留
     * @param e 异常对象，任意的一个异常通知
     */
    public void afterThrowing(Exception e){
        System.out.println("异常通知,"+e.getMessage());
    }

}
