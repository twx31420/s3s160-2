package edu.nf.homework.dao;

import edu.nf.homework.entity.Item;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/14
 */
public interface ItemDao {
    /**
     * 添加商品
     * @param item
     */
    void save(Item item);

    /**
     * 查询所有的商品
     * @return
     */
    List<Item> getItems();

    /**
     * 修改商品信息
     * @param item
     */
    void update(Item item);

    /**
     * 删除商品信息
     * @param id
     */
    void delete(int id);
}
