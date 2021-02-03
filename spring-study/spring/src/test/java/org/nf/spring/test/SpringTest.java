package org.nf.spring.test;

import org.junit.Test;
import org.nf.spring.bean.User;
import org.nf.spring.core.BeanFactory;

/**
 * @author 天文学
 * @date 2020/12/3
 */
public class SpringTest {
    @Test
    public void testBean(){
        //创建工厂容器
        BeanFactory factory = new BeanFactory("org.nf.spring");
        User w1 = (User) factory.getBean("user");
        User w2 = factory.getBean("user", User.class);
        System.out.println(w1 == w2);
    }
}
