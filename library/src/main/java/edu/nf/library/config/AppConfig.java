package edu.nf.library.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
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
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@Configuration
@ComponentScan(basePackages = "edu.nf.library" ,excludeFilters = @ComponentScan.Filter(Controller.class))
@MapperScan("edu.nf.library.dao")//这个注解等同于xml中的<mybatis:scan/>
@EnableTransactionManagement //启用事务注解驱动，等同于mxl中的<tx:annotation-driven transaction-manager="txManager"/>
public class AppConfig {

    /**
     * 配置数据源
     * @return
     * @throws Exception
     */
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource()throws Exception{
        Properties prop = new Properties();
        InputStream is=AppConfig.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        DruidDataSource dataSource=(DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        return dataSource;
    }

    /**
     * 整合mybatis
     * 注入一个数据源
     * @param dataSource
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource)throws IOException {
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("edu.nf.library.entity");
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        //配置分页插件
        PageInterceptor pageInterceptor=new PageInterceptor();
        Properties prop = new Properties();
        prop.setProperty("helperDialect","mysql");
        prop.setProperty("supportMethodsArguments","true");
        prop.setProperty("reasonable","true");
        pageInterceptor.setProperties(prop);
        factoryBean.setPlugins(pageInterceptor);
        //设置日志
        org.apache.ibatis.session.Configuration conf=new org.apache.ibatis.session.Configuration();
        conf.setLogImpl(StdOutImpl.class);
        factoryBean.setConfiguration(conf);
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
