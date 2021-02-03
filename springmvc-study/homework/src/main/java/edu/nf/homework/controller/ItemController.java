package edu.nf.homework.controller;

import edu.nf.homework.entity.Item;
import edu.nf.homework.service.ItemService;
import edu.nf.homework.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@RestController
public class ItemController extends BaseController{

    @Autowired
    @Qualifier("itemService")
    private ItemService itemService;

    @PostMapping("/item/add")
    public ResultVO save(Item item){
        System.out.println(item);
        itemService.save(item);
        return success();
    }
    @GetMapping("/item/list")
    public ResultVO getItems(){
        List<Item> list=itemService.getItems();
        return success(list);
    }
    @PostMapping("/item/update")
    public ResultVO update(Item item){
        itemService.update(item);
        return success();
    }
    @GetMapping("/item/del/{id}")
    public ResultVO delete(@PathVariable("id") int id){
        itemService.delete(id);
        return success();
    }
}
