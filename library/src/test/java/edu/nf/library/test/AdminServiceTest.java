package edu.nf.library.test;

import edu.nf.library.config.AppConfig;
import edu.nf.library.config.WebInitializer;
import edu.nf.library.controller.AdminController;
import edu.nf.library.entity.Admin;
import edu.nf.library.service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 天文学
 * @date 2021/1/7
 */
public class AdminServiceTest {
    @Test
    public void testLogin(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        AdminService service=context.getBean("adminService",AdminService.class);
        Admin ad=new Admin();
        ad.setAdminId("202010");
        ad.setAdminName("admin");
        ad.setAdminPwd("111");
        service.login(ad);

    }
}
