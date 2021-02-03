package edu.nf.homework.test;

import edu.nf.homework.config.WebMvcConfig;
import edu.nf.homework.controller.AdminController;
import edu.nf.homework.entity.Admin;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author 天文学
 * @date 2021/1/14
 */
public class AdminTest {
    @Test
    public void testLogin(){
        Admin admin=new Admin();
        admin.setAccount("admin");
        admin.setPwd("admin");
        ApplicationContext context=new AnnotationConfigApplicationContext(WebMvcConfig.class);
        AdminController controller=context.getBean(AdminController.class);
//        controller.login(admin);
    }
}
