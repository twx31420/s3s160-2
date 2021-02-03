package org.nf.homework.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.nf.homework.util.MybatisUtils;

/**
 * @author 天文学
 * @date 2021/1/6
 */
public class MybatisUtilsTest {
    @Test
    public void testGetSqlSession(){
        SqlSession session= MybatisUtils.getSqlSession(true);
        System.out.println(session);
        session.close();
    }

}
