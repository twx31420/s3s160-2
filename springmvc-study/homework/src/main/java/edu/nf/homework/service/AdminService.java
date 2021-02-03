package edu.nf.homework.service;

import edu.nf.homework.entity.Admin;

/**
 * @author 天文学
 * @date 2021/1/14
 */
public interface AdminService {

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);


}
