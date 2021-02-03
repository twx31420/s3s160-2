package edu.nf.ch10.service.impl;

import edu.nf.ch10.entity.User;
import edu.nf.ch10.exception.LoginException;
import edu.nf.ch10.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author 天文学
 * @date 2021/1/13
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public User check(String userName, String pwd) {
        User user=new User();
        user.setUserName("user1");
        user.setPwd("123");
        if(user!=null && pwd.equals(user.getPwd())){
            return user;
        }
         throw new LoginException("用户或密码错误！");
    }
}
