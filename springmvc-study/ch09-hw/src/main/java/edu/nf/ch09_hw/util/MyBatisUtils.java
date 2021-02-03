package edu.nf.ch09_hw.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 天文学
 * @date 2021/1/12
 */
public class MyBatisUtils {
    //存储sqlsessionfactory
    private static SqlSessionFactory sqlSessionFactory;
    //获取sqlsessionfactory
    static {
        try {
            InputStream is= Resources.getResourceAsStream("mybatis.xml");
            Configuration config;
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlsession
    public static SqlSession getSqlSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }
}
