package edu.nf.ch04.dao;

import edu.nf.ch04.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/20
 */
public interface CityDao {

    List<City> listCity(@Param("pageNum")Integer pageNum,@Param("pageSize") Integer pageSize);
}
