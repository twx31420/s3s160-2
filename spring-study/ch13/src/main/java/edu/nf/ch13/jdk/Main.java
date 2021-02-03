package edu.nf.ch13.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 天文学
 * @date 2020/12/7
 */
public class Main {
    public static void main(String[] args) {
        //创建jdk动态代理需要的满足的三个必要条件
        //创建回调处理器
        InvocationHandler handler=new LogInvocationHandler(new UserServiceImpl());
        //获取一个类加载IQ，用于加载动态创建出来的代理字节码，加载成功后将自动创建出一个代理实例
        ClassLoader loader=Main.class.getClassLoader();
        //获取目标对象所实现的接口的class
        Class<?> [] infClasses=UserServiceImpl.class.getInterfaces();
        //使用proxy来创建代理对象，并且创建出来代理对象会自动实现上面的接口
        UserService service=(UserService)Proxy.newProxyInstance(loader,infClasses,handler);
        //调用代理对象
        service.add();
        service.getUser();
        service.update();
    }
}
