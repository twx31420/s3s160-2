package edu.nf.library.service.impl;

import edu.nf.library.dao.AdminDao;
import edu.nf.library.entity.Admin;
import edu.nf.library.exception.LoginException;
import edu.nf.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 天文学
 * @date 2021/1/7
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        Admin admin1=adminDao.login(admin);
        if(admin1!=null && admin.getAdminPwd().equals(admin1.getAdminPwd())){
            return admin;
        }else {
            throw new LoginException("你填写的信息有误！");
        }
    }
}
