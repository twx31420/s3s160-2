package org.nf.project.dao;

import org.nf.project.entity.User;

/**
 * @author 天文学
 * @date 2021/1/12
 */
public interface UserDao {

    /**
     * 添加
     * @param user
     */
    void addUser(User user);

    /**
     * 查询用户
     * @param uid
     * @return
     */
    User getUserById(int uid);
}
