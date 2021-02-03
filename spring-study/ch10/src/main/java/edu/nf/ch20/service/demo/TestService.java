package edu.nf.ch20.service.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author 天文学
 * @date 2020/12/4
 */
@Service
//从classpath路径下找到data.properties文件
@PropertySource(value = "classpath:data.properties")
public class TestService {
    //注解中使用SpEl表示是指定文件中的key
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;


    public void say(){
        System.out.println(name+","+age);
    }
}
