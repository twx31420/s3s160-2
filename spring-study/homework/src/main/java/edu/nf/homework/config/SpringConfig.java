package edu.nf.homework.config;

import edu.nf.homework.controller.UserController;
import edu.nf.homework.dao.UserDao;
import edu.nf.homework.factroybean.MyFactroyBean;
import edu.nf.homework.service.Service;
import edu.nf.homework.service.impl.UserService;
import edu.nf.homework.util.MybatisUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 天文学
 * @date 2020/12/21
 */
@Configuration
//使用配置类同样可以进行扫描，
//@ComponentScan(basePackages = "edu.nf.homework")
public class SpringConfig {

//    @Bean(name="userDao")
    @Bean
    public UserDao userDao()throws Exception{
        MyFactroyBean bean=new MyFactroyBean();
        bean.setDaoInterface(UserDao.class);
        return (UserDao)bean.getObject();
    }

//    @Bean(name = "service")
    @Bean
    public Service userService(UserDao userDao)throws Exception{
        UserService service=new UserService();
        service.setUserDao(userDao);
        return service;
    }

    @Bean
    public UserController controller(UserService userService)throws Exception{
        UserController controller=new UserController();
        controller.setService(userService);
        return controller;
    }

}
