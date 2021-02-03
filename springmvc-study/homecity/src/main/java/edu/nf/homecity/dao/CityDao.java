package edu.nf.homecity.dao;

import edu.nf.homecity.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/17
 */
public interface CityDao {

    List<City> getList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
