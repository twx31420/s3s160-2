package org.nf.homework.controller;

import org.nf.homework.entity.Student;
import org.nf.homework.service.StuService;
import org.nf.homework.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@RestController
public class StuController extends BaseController {
    @Autowired
    private StuService service;

    @GetMapping("/student/list")
    public ResultVo<List<Student>> listStu(){
        List<Student> list=service.listStu();
        ResultVo<List<Student>> vo=success(list);
        return vo;
    }

    @PostMapping("/student/add")
    public ResultVo addStu(@Valid Student s, BindingResult result){
        if(result.hasErrors()){
            List<String> messages=new ArrayList<>();
            for (FieldError fieldError:result.getFieldErrors()){
                messages.add(fieldError.getDefaultMessage());
            }
            return fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),messages);
        }else {
            service.addStu(s);
            return success("success");
        }
    }

    @PostMapping("/student/del")
    public ResultVo delStu( int[] sids){
        System.out.println(sids.length);
        try {
            service.delStu(sids);
            return success("success");
        } catch (Exception e) {
            return fail(500,e.getMessage());
        }
    }
}
