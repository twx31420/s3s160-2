package edu.nf.ch05.controller;

import edu.nf.ch05.entity.User;
import edu.nf.ch05.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@RestController
public class UserController extends BaseController{

    @PostMapping("/login")
    public ResultVO login(User user){
        return null;
    }
}
