package org.nf.homework.controller;

import org.nf.homework.entity.ClassInfo;
import org.nf.homework.service.ClassService;
import org.nf.homework.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@RestController
public class ClassController extends BaseController{
    @Autowired
    private ClassService classServiceImpl;

    @GetMapping("/class/list")
    public ResultVo<List<ClassInfo>> listClass(){
        List<ClassInfo> list=classServiceImpl.listClass();
        ResultVo<List<ClassInfo>> vo=new ResultVo<>();
        vo.setCode(200);
        vo.setData(list);
        return vo;
    }
}
