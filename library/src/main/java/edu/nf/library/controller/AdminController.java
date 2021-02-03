package edu.nf.library.controller;

import edu.nf.library.entity.Admin;
import edu.nf.library.service.AdminService;
import edu.nf.library.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 天文学
 * @date 2021/1/7
 */
@RestController
public class AdminController extends BaseController{

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResultVO login(Admin admin, HttpSession session){
        Admin admin1=adminService.login(admin);
        session.setAttribute("admin",admin1);
        return success();
    }
}
