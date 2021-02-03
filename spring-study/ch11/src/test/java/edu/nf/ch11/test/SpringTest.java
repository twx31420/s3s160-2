package edu.nf.ch11.test;

import edu.nf.ch11.config.SpringConfig;
import edu.nf.ch11.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 天文学
 * @date 2020/12/4
 */
public class SpringTest {
    @Test
    public void testConfig(){
        //使用配置类后，那么应该使用另一个spring的上下容器
        ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller=context.getBean("userController",UserController.class);
        controller.save();
    }
}
