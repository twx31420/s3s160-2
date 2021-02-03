package edu.nf.ch12.config;

import edu.nf.ch12.controller.UserController;
import edu.nf.ch12.dao.UserDao;
import edu.nf.ch12.dao.impl.UserDaoImpl;
import edu.nf.ch12.service.UserService;
import edu.nf.ch12.service.impl.StuServiceImpl;
import edu.nf.ch12.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/**
 * @author 天文学
 * @date 2020/12/4
 */
@Configuration
//使用配置类同样可以进行扫描，
@ComponentScan(basePackages = "edu.nf.ch12")
public class SpringConfig {

    /**
     * 装配dao
     * 使用bean注解来转配
     * 方法名默认就是bean的id
     * 也可以通过name属性从新自定义
     */
    @Bean(name = "dao",initMethod = "init",destroyMethod = "dectory")
    //@Scope注解也可以声明在方法上
    //@Scope
    //@Primary注解也可以标注在方法上，表示优先注入这个bean
    //@Primary
    public UserDao userDao(){
        return new UserDaoImpl();
    }


    /**
     * 装配service
     */
    @Bean
    public UserService userService(UserDao userDao){
        UserServiceImpl service=new UserServiceImpl();
        //手动调用set方法进行注入
        //方法一：调用userDao的方法获取dao的bean进行注入
//        service.setUserDao(userDao());
        //方式二：通过spring传进的参数进行注入
        service.setUserDao(userDao);
        return service;
    }

    @Bean
    public UserService stuService(UserDao userDao){
        StuServiceImpl service =new StuServiceImpl();
        service.setUserDao(userDao);
        return service;
    }

    /**
     * 当有多个实现类时，会先根据参数的变量名称作为id到容器查找
     * 如果找到则直接传入进来注入，找不到则引发异常
     * 因此可以结合@Quelifier注解，标识在参数上
     * @param userService
     * @return
     *
     *
     */
    @Bean
    public UserController userController(@Qualifier("stuService") UserService service){
        UserController controller=new UserController();
        //注入UserService
        controller.setService(service);
        return controller;
    }

}
