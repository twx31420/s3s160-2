package edu.nf.homework.service.impl;

import edu.nf.homework.dao.ItemDao;
import edu.nf.homework.entity.Item;
import edu.nf.homework.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Override
    public void save(Item item) {
        itemDao.save(item);
    }

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public void update(Item item) {
        itemDao.update(item);
    }

    @Override
    public void delete(int id) {
        itemDao.delete(id);
    }
}
