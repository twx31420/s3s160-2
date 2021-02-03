package edu.nf.homecity.dao.impl;

import edu.nf.homecity.dao.CityDao;
import edu.nf.homecity.entity.City;
import edu.nf.homecity.util.MyBatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/17
 */
@Repository
public class CityDaoImpl implements CityDao {
    @Override
    public List<City> getList(Integer pageNum,Integer pageSize) {
        try(SqlSession sqlSession= MyBatisUtils.getSqlSession(true)){
            return sqlSession.getMapper(CityDao.class).getList(pageNum,pageSize);
        }catch (Exception e){
            throw e;
        }
    }
}
