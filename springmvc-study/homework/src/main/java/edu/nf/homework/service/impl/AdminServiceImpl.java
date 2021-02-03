package edu.nf.homework.service.impl;

import edu.nf.homework.dao.AdminDao;
import edu.nf.homework.entity.Admin;
import edu.nf.homework.exception.LoginException;
import edu.nf.homework.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        Admin ad=adminDao.login(admin);
        if(ad!=null && admin.getPwd().equals(ad.getPwd())){
            return ad;
        }
        throw new LoginException("用户名或密码错误！");
    }
}
