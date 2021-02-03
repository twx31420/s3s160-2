package edu.nf.ch04.service;

import com.github.pagehelper.PageInfo;
import edu.nf.ch04.entity.City;

/**
 * @author 天文学
 * @date 2021/1/20
 */
public interface CityService {

    /**
     * 查询城市列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<City> listCity(Integer pageNum,Integer pageSize);
}
