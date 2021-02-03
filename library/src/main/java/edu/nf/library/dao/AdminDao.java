package edu.nf.library.dao;

import edu.nf.library.entity.Admin;

/**
 * @author 天文学
 * @date 2020/12/29
 */
public interface AdminDao {
    /**
     * 管理员登入方法
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}
