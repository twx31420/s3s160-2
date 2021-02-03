package edu.nf.library.service;

import edu.nf.library.entity.Admin;

/**
 * @author 天文学
 * @date 2021/1/7
 */
public interface AdminService {

    /**
     * 管理员登入方法
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}
