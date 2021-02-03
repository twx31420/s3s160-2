package edu.nf.ch02.service;

import edu.nf.ch02.entity.City;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/19
 */
public interface CityService {
    /**
     * 根据id查询城市信息
     * @param id
     * @return
     */
    City getCityById(int id);

    List<City> listCity(int pageNum,int pageSize);
}
