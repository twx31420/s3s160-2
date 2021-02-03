package edu.nf.ch01_dbcp2.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author 天文学
 * @date 2021/1/18
 */
public class Dbcp2test {
    @Test
    public void testCon()throws Exception{
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource=context.getBean("hikair",DataSource.class);
        Connection con=dataSource.getConnection();
        System.out.println("hikair连接对象："+con);
        con.close();

    }
}
