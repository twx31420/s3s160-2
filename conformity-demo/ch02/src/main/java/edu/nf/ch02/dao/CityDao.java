package edu.nf.ch02.dao;

import edu.nf.ch02.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/19
 */
public interface CityDao {
    /**
     * 根据id获取城市信息
     * @param id
     * @return
     */
    City getCityById(int id);

    List<City> listCity(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
}
