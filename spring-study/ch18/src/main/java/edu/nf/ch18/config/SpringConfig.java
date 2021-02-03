package edu.nf.ch18.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 天文学
 * @date 2020/12/9
 */
@Configuration
@ComponentScan(basePackages = "edu.nf.ch18")
//启用aop的注解处理器，等通用xml中的<aop:aspectj-autoproxy/>
//proxyTargetClass属性表示是否强制使用cglib动态代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {


}
