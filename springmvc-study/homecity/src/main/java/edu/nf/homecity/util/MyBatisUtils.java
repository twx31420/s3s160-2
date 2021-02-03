package edu.nf.homecity.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 天文学
 * @date 2021/1/17
 */
public class MyBatisUtils {
    /**
     * 保存sqlsessionfactory
     */
    public static SqlSessionFactory sqlSessionFactory;

    /**
     * 初始化
     */
    static {
        try {
            InputStream is= Resources.getResourceAsStream("mybatis.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sqlSession对象
     * @param autoCommit
     * @return
     */
    public static SqlSession getSqlSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }
}
