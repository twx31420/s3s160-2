package edu.nf.ch05.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 天文学
 * @date 2021/1/21
 * 配置类，取代applicationcontext.XML
 */
@Configuration
@ComponentScan(basePackages = "edu.nf.ch05",
        excludeFilters = @ComponentScan.Filter(Controller.class))
@MapperScan("edu.nf.ch05.dao")//这个注解等同于xml中的<mybatis:scan/>
@EnableTransactionManagement //启用事务注解驱动，等同于mxl中的<tx:annotation-driven transaction-manager="txManager"/>
public class AppConfig {

    /**
     * 装配Druid数据源连接池
     * @return
     */
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource()throws Exception {
        Properties prop=new Properties();
        InputStream is=AppConfig.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        DruidDataSource dataSource=(DruidDataSource)DruidDataSourceFactory.createDataSource(prop);
        return dataSource;
    }

    /**
     * 整合mybatis，装配SqlSessionFactoryBean
     * 参数注入一个数据源
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource)throws IOException{
        //初始化sqlSessionFactory
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        //注入数据源
        factoryBean.setDataSource(dataSource);
        //设置实体包的默认别名
        factoryBean.setTypeAliasesPackage("edu.nf.ch05.entity");
        //设置mapper映射文件的路径
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        //配置分页插件
        PageInterceptor pageInterceptor=new PageInterceptor();
        //设置分页属性
        Properties prop=new Properties();
        prop.setProperty("helperDialect","mysql");
        prop.setProperty("supportMethodsArguments","true");
        prop.setProperty("reasonable","true");
        //将分页属性配置到拦截器中
        pageInterceptor.setProperties(prop);
        //将拦截器设置到插件中
        factoryBean.setPlugins(pageInterceptor);
        return factoryBean;
    }

    /**
     * 装配事务管理器，并注入数据源
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }




}
