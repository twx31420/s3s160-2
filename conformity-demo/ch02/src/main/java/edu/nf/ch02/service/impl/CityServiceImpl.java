package edu.nf.ch02.service.impl;

import edu.nf.ch02.dao.CityDao;
import edu.nf.ch02.entity.City;
import edu.nf.ch02.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/19
 */
@Service("cityService")
public class CityServiceImpl implements CityService {
    /**
     * 注入dao
     */
    @Autowired
    private CityDao cityDao;

    @Override
    public City getCityById(int id) {
        return cityDao.getCityById(id);
    }

    @Override
    public List<City> listCity(int pageNum, int pageSize) {
        return cityDao.listCity(pageNum,pageSize);
    }
}
