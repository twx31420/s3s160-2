package edu.nf.homework.config;

import edu.nf.homework.dao.AdminDao;
import edu.nf.homework.dao.ItemDao;
import edu.nf.homework.dao.TypeDao;
import edu.nf.homework.factorybean.MyFatoryBean;
import edu.nf.homework.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@ComponentScan(basePackages = "edu.nf.homework")
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置工厂
     */
    @Bean(name = "adminDao")
    public AdminDao adminDao() throws Exception{
        MyFatoryBean bean=new MyFatoryBean();
        bean.setClazz(AdminDao.class);
        return (AdminDao) bean.getObject();
    }
    @Bean(name = "typeDao")
    public TypeDao typeDao() throws Exception{
        MyFatoryBean bean=new MyFatoryBean();
        bean.setClazz(TypeDao.class);
        return (TypeDao)bean.getObject();
    }
    @Bean(name = "itemDao")
    public ItemDao itemDao()throws Exception{
        MyFatoryBean bean=new MyFatoryBean();
        bean.setClazz(ItemDao.class);
        return (ItemDao) bean.getObject();
    }

    /**
     * 启动静态资源
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置拦截器
     */
/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/login","/login.html","/css/**","/js/**");
    }*/

    /**
     * 内部资源视图解析器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setPrefix(".jsp");
        registry.viewResolver(viewResolver);
    }
}
