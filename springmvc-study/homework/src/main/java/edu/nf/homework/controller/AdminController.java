package edu.nf.homework.controller;

import edu.nf.homework.entity.Admin;
import edu.nf.homework.service.AdminService;
import edu.nf.homework.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@RestController
public class AdminController extends BaseController{

    @Autowired
    @Qualifier("adminService")
    private AdminService service;
    @PostMapping("/admin/login")
    public ResultVO login(Admin admin,HttpSession session){
       Admin ad= service.login(admin);
       session.setAttribute("admin",ad);
       return success(ad);
    }
}
