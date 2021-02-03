package edu.nf.ch03.config;

import edu.nf.ch03.controller.UserController;
import edu.nf.ch03.dao.UserDao;
import edu.nf.ch03.entity.User;
import edu.nf.ch03.factorybean.MyFactoryBean;
import edu.nf.ch03.service.UserService;
import edu.nf.ch03.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 天文学
 * @date 2021/1/1
 */
@Configuration
@EnableWebMvc
public class UserConfig implements WebMvcConfigurer {
    @Bean
    public UserDao dao() throws Exception{
        MyFactoryBean bean=new MyFactoryBean(UserDao.class);
        return (UserDao)bean.getObject();
    }




}
