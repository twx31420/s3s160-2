package edu.nf.ch06_hw.controller;

import edu.nf.ch06_hw.entity.ClassInfo;
import edu.nf.ch06_hw.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/5
 */
@Controller
public class ClassInfoController {
    @Autowired
    private ClassInfoService claservice;

    @GetMapping("/getcla")
    @ResponseBody
    public List<ClassInfo> getInfo(){
        return claservice.getInfo();
    }
}
