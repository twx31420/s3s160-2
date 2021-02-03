package edu.nf.homewrok.test;

import edu.nf.homework.config.SpringConfig;
import edu.nf.homework.controller.UserController;
import edu.nf.homework.dao.UserDao;
import edu.nf.homework.entity.User;
import edu.nf.homework.service.Service;
import edu.nf.homework.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/21
 */
public class SpringTest {


    @Test
    public void testConfig(){
        SqlSession sqlSession= MybatisUtils.getSqlSession(false);
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
//        UserController controller=context.getBean(UserController.class);
//        controller.query();
        UserDao dao=context.getBean(UserDao.class);
//        dao.select().forEach(user -> {
//            System.out.println(user.getName());
//        });
        dao.add(new User(null,"user5 "));
        sqlSession.commit();
    }
}
