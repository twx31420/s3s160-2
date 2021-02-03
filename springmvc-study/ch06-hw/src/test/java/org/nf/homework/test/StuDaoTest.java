package org.nf.homework.test;

import org.junit.Test;
import org.nf.homework.controller.StuController;
import org.nf.homework.dao.StuDao;
import org.nf.homework.dao.impl.StuDaoImpl;
import org.nf.homework.entity.ClassInfo;
import org.nf.homework.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 天文学
 * @date 2021/1/6
 */
public class StuDaoTest {
    @Test
    public void testListStu(){
//        StuDao dao=new StuDaoImpl();
        ApplicationContext context=new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
        StuDao dao=context.getBean("stuDaoImpl",StuDao.class);
        dao.listStu().forEach(s->{
            System.out.println(s.getStuName());
        });
    }
    @Test
    public void testAddStu(){
        ApplicationContext context=new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
        StuDao dao=context.getBean("stuDaoImpl",StuDao.class);
        Student s=new Student();
        s.setStuName("fanjiaying");
        s.setAge(23);
        s.setCla(new ClassInfo());
        dao.addStu(s);
    }
    @Test
    public void text(){
        ApplicationContext context=new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
        StuController controller=context.getBean(StuController.class);
        int [] a={27,28};
        controller.delStu(a);
    }
}
