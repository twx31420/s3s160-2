package edu.nf.homework.dao;

import edu.nf.homework.entity.Type;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/14
 */
public interface TypeDao {
    /**
     * 添加商品类型
     * @param type
     */
    void save(Type type);

    /**
     * 查询所有类型
     * @return
     */
    List<Type> getTypes();


}
