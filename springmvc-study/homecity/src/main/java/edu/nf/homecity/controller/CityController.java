package edu.nf.homecity.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.homecity.entity.City;
import edu.nf.homecity.service.CityService;
import edu.nf.homecity.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 天文学
 * @date 2021/1/17
 */
@RestController
public class CityController extends BaseController {

    @Autowired
    private CityService cityServiceImpl;

    @PostMapping("/list")
    public ResultVO getList(int pageNum, int pageSize){
        PageInfo<City> pageInfo=cityServiceImpl.getCityList(pageNum,pageSize);
        return success(pageInfo);
    }

}
