package edu.nf.ch06_hw.config;

import edu.nf.ch06_hw.dao.ClassInfoDao;
import edu.nf.ch06_hw.dao.StudentDao;
import edu.nf.ch06_hw.factorybean.MyFactoryBean;
import edu.nf.ch06_hw.service.ClassInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 天文学
 * @date 2021/1/5
 */
@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "edu.nf.ch06_hw")
public class SpringConfig implements WebMvcConfigurer {
    @Bean(name = "dao")
    public StudentDao dao()throws Exception{
        MyFactoryBean bean=new MyFactoryBean(StudentDao.class);
        return (StudentDao)bean.getObject();
    }
    @Bean(name = "cladao")
    public ClassInfoDao caldao()throws Exception{
        MyFactoryBean bean=new MyFactoryBean(ClassInfoDao.class);
        return (ClassInfoDao)bean.getObject();
    }


}
