package edu.nf.homework.dao.impl;

import edu.nf.homework.dao.AdminDao;
import edu.nf.homework.dao.ItemDao;
import edu.nf.homework.entity.Item;
import edu.nf.homework.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/14
 */
//@Repository("itemDao")
public class ItemDaoImpl implements ItemDao {
    @Override
    public void save(Item item) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            sqlSession.getMapper(ItemDao.class).save(item);
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public List<Item> getItems() {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            return sqlSession.getMapper(ItemDao.class).getItems();
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public void update(Item item) {

        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
           sqlSession.getMapper(ItemDao.class).update(item);
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession sqlSession= MybatisUtils.getSqlSession(true)){
            sqlSession.getMapper(ItemDao.class).delete(id);
        }catch (RuntimeException e){
            throw e;
        }
    }
}
