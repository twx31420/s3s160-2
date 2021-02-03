package edu.nf.hw.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 天文学
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try{
            InputStream in= Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            sqlSessionFactory=builder.build(in);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(boolean antoCommit){
        return sqlSessionFactory.openSession(antoCommit);
    }
}
