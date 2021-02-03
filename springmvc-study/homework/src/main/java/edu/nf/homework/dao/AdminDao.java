package edu.nf.homework.dao;

import edu.nf.homework.entity.Admin;

/**
 * @author 天文学
 * @date 2021/1/14
 */
public interface AdminDao {
    /**
     * 管理员登入
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}
