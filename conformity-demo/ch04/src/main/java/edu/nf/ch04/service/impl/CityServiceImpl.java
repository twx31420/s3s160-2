package edu.nf.ch04.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.ch04.dao.CityDao;
import edu.nf.ch04.entity.City;
import edu.nf.ch04.service.CityService;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/20
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public PageInfo<City> listCity(Integer pageNum, Integer pageSize) {
        PageInfo<City> pageInfo= null;
        List<City> list=cityDao.listCity(pageNum,pageSize);
        pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
