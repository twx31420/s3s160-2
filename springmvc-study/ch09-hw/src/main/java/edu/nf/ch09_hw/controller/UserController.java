package edu.nf.ch09_hw.controller;

import edu.nf.ch09_hw.entity.User;
import edu.nf.ch09_hw.service.UserService;
import edu.nf.ch09_hw.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@RestController
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public ResultVO login(User user, HttpSession session){
       User user1= userService.login(user);
       session.setAttribute("user",user1);
       return success(user1);
    }

    @PostMapping("/user/save")
    public ResultVO save(User user){
        userService.save(user);
        return success();
    }
    @GetMapping("/user/list")
    public ResultVO getList(){
        List<User> list=userService.getList();
        return success(list);
    }
    @PostMapping("/user/update")
    public ResultVO update(User user){
        userService.update(user);
        return success();
    }
    @GetMapping("/user/del/{id}")
    public ResultVO delete(@PathVariable("id") int id){
        userService.delete(id);
        return success();
    }
}
