package edu.nf.ch02.test;

import edu.nf.ch02.entity.City;
import edu.nf.ch02.service.CityService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/19
 */
public class CityDaoTest {
    @Test
    public void testGetCityById(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CityService service=context.getBean("cityService",CityService.class);
        City city =service.getCityById(101010100);
        System.out.println(city.getCityName());
        System.out.println(city.getCityCode());
        System.out.println(city.getProvince());
    }

    @Test
    public void testListCity(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CityService service=context.getBean("cityService",CityService.class);
        List<City> list=service.listCity(1,10);
        list.forEach(c->{
            System.out.println(c.getCityName());
        });
    }
}
