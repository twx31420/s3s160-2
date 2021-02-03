package edu.nf.ch21.test;

import edu.nf.ch21.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author 天文学
 * @date 2020/12/9
 */
public class TaskTest {
    @Test
    public void testTask(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        while (true);
    }
}


