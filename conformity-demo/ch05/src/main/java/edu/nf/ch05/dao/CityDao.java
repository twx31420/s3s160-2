package edu.nf.ch05.dao;

import edu.nf.ch05.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/21
 */
public interface CityDao {
    /**
     * 查询城市列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<City> listCity(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
}
