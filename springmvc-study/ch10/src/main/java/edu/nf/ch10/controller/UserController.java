package edu.nf.ch10.controller;

import edu.nf.ch10.entity.User;
import edu.nf.ch10.service.LoginService;
import edu.nf.ch10.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 天文学
 * @date 2021/1/13
 */
@RestController
public class UserController extends BaseController{
    @Autowired
    private LoginService loginService;
    @PostMapping("/userlogin")
    public ResultVO login(String userName, String pwd, HttpSession session){
           User user= loginService.check(userName,pwd);
           //将用户信息保存会话中
            session.setAttribute("user",user);
           return success(user);
    }
}
