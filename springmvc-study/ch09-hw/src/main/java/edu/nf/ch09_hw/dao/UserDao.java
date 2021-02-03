package edu.nf.ch09_hw.dao;

import edu.nf.ch09_hw.entity.User;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/12
 */

public interface UserDao {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
    /**
     * 保存的方法
     * @param user
     */
    void save(User user);

    /**
     * 查询所有的方法
     * @return
     */
    List<User> getList();

    /**
     * 修改用户的方法
     * @param user
     */
    void update(User user);

    /**
     * 删除用户的方法
     * @param id
     */
    void delete(int id);
}
