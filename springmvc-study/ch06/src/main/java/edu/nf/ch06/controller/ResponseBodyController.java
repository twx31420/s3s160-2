package edu.nf.ch06.controller;

import edu.nf.ch06.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/5
 */
//@Controller
//    @RestController用于实现restful风格的api请求，
//    好处是自动在每个方法上加入@ResponBody注解
//    如果当前类返回的都是json数据，可以直接使用此注解即可
@RestController
public class ResponseBodyController {

    @GetMapping("/getstu")
//    @ResponseBody
    public Student getStudent(){
        Student s=new Student();
        s.setId(1);
        s.setName("stu1");
        s.setAge(21);
        return s;
    }
    @GetMapping("/list")
//    @ResponseBody
    public List<Student> listStudent(){
        List<Student> list =new ArrayList<>();
        list.add(new Student(1,"stu1",19));
        list.add(new Student(2,"stu2",20));
        list.add(new Student(3,"stu3",21));
        return list;
    }
}
