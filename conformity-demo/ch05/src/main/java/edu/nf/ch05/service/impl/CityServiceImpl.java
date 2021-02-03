package edu.nf.ch05.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.ch05.dao.CityDao;
import edu.nf.ch05.entity.City;
import edu.nf.ch05.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Override
    public PageInfo<City> listCity(Integer pageNum, Integer pageSize) {
        List<City>list=cityDao.listCity(pageNum,pageSize);
        PageInfo<City> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
