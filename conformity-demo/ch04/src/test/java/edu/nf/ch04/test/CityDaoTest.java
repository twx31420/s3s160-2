package edu.nf.ch04.test;

import edu.nf.ch04.dao.CityDao;
import edu.nf.ch04.entity.City;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/20
 */
public class CityDaoTest {
    @Test
    public void testListCity(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CityDao dao =context.getBean("cityDao",CityDao.class);
        List<City> list =dao.listCity(1,1);
        list.forEach(c-> System.out.println(c.getCityName()));
    }
}
