package edu.nf.homecity.service;

import com.github.pagehelper.PageInfo;
import edu.nf.homecity.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/17
 */
public interface CityService {
    PageInfo<City> getCityList(Integer pageNum,Integer pageSize);
}
