package edu.nf.ch09.dao;

import edu.nf.ch09.entity.User;

/**
 * @author 天文学
 * @date 2021/1/12
 */
public interface UserDao {
    /**
     * 添加用户信息
     * @param user
     */
    void save(User user);
}
