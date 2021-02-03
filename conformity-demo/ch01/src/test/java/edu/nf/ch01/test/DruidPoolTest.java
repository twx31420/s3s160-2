package edu.nf.ch01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author 天文学
 * @date 2021/1/18
 */
public class DruidPoolTest {
    @Test
    public void testDataSource()throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//        从容器中获取连接,这里的数据源实现就是druid连接池
        DataSource dataSource =context.getBean("dataSource", DataSource.class);
//        从数据源中获取connection对象
        Connection con=dataSource.getConnection();
        System.out.println("连接对象:"+con);
//        关闭连接
        con.close();
    }
}
