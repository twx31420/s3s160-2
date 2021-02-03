package edu.nf.ch05.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.ch05.entity.City;
import edu.nf.ch05.service.CityService;
import edu.nf.ch05.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@RestController
public class CityController extends BaseController{
    @Autowired
    private CityService cityService;

    @GetMapping("/city/list")
    public ResultVO listCity(int pageNum,int pageSize){
        PageInfo<City> pageInfo=cityService.listCity(pageNum,pageSize);
        return  success(pageInfo);
    }
}
