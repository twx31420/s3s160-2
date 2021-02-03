package edu.nf.ch09_hw.service;

import edu.nf.ch09_hw.entity.User;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/12
 */
public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
    /**
     * 添加用户信息
     * @param user
     */
    void save(User user);

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getList();

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(int id);
}
