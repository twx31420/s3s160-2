package edu.nf.ch11.config;

import edu.nf.ch11.interceptor.TestInterceptor;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author 天文学
 * @date 2021/1/14
 * 使用注解配置类取代dispatcher-servlet。xml
 */
@ComponentScan(basePackages = "edu.nf.ch11")
@Configuration
//请用mvc注解驱动,等同于xml中的<mvc:annotion-driven>
@EnableWebMvc
/**
 * 如果需要扩展webmvc的配置，可以实现webmvcconfigurer接口
 * 覆盖相关的默认方法
 */
public class WebConfig implements WebMvcConfigurer {

    /**
     * 静态资源处理方式一：使用默认的Servlet
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //启用默认的Servlet支持即可
        configurer.enable();
    }

    /**
     * 静态资源处理方式二：基于springmvc来处理
     */
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/page/**")
                .addResourceLocations("/static");
    }*/

    /**
     * 配置拦截器
     * 注意：如果使用默认的Servlet来处理静态资源，那么这些静态资源是不会经过拦截器的
     * 如果要拦截静态资源，那么就需要使用spring的静态资源处理机制
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/login.html","/css/**","/js/**");
    }
    /**
     * 配置commons-fileupload文件上传解析器
     */
 /*   @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        //设置上传的大小
        resolver.setMaxUploadSize(102857600);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }*/

    /**
     * 配置日期格式化器
     */
   /* @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }*/

    /**
     * 配置bean验证器
     */
    @Override
    public Validator getValidator() {
        //创建Bean验证器的FactoryBean
        LocalValidatorFactoryBean factoryBean=new LocalValidatorFactoryBean();
        factoryBean.setProviderClass(HibernateValidator.class);
        //配置消息资源的bean
        ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
        //设置提示消息资源
        messageSource.setBasename("classpath:message");
        //设置编码
        messageSource.setDefaultEncoding("UTF-8");
        factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;
    }

    /**
     * 配置视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //创建内部资源视图解析器
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        //通过视图解析器注册机来注册这个视图解析器
        registry.viewResolver(viewResolver);
//        registry.jsp("/WEB-INF/jsp/",".jsp");
    }


}
