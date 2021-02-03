package edu.nf.ch06_hw.controller;

import edu.nf.ch06_hw.entity.ClassInfo;
import edu.nf.ch06_hw.entity.Student;
import edu.nf.ch06_hw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/5
 */
@Controller
public class StudentController{

    @Autowired
    private StudentService ser;

    @GetMapping("/getlist")
    @ResponseBody
    public List<Student> getList(){
        return ser.list();
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean add(Student stu){
        try {
            ser.add(stu);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
