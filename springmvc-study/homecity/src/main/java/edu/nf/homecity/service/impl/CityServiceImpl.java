package edu.nf.homecity.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.homecity.dao.CityDao;
import edu.nf.homecity.entity.City;
import edu.nf.homecity.service.CityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/17
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDaoImpl;
    @Override
    public PageInfo<City> getCityList(Integer pageNum, Integer pageSize){
        return new PageInfo<>(cityDaoImpl.getList(pageNum,pageSize));
    }
}
