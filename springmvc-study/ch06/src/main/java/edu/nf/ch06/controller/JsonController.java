package edu.nf.ch06.controller;

import edu.nf.ch06.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@RestController
public class JsonController {
    /**
     * 使用@RequestBody注解接收请求中的字符串内容，列如JSON字符串
     * @param s
     * @return
     */
    @PostMapping("/json/data")
    public String add(@RequestBody Student s){
        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getAge());
        return "success";
    }
}
