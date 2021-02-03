package edu.nf.homework.controller;

import edu.nf.homework.entity.Type;
import edu.nf.homework.service.TypeService;
import edu.nf.homework.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@RestController
public class TypeController extends BaseController{

    @Autowired
    @Qualifier("typeService")
    private TypeService typeService;

    @GetMapping("/type/list")
    public ResultVO getTypes(){
        List<Type> list=typeService.getTypes();
        return success(list);
    }
    @PostMapping("/type/add")
    public ResultVO save(Type type){
        typeService.save(type);
        return success();
    }
}
