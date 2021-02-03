package edu.nf.ch05.service.impl;

import edu.nf.ch05.entity.User;
import edu.nf.ch05.exception.LoginException;
import edu.nf.ch05.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User check(User user) {
        //根据用户名从数据库查询user对象
        if("wangl".equals(user.getName())&& "123".equals(user.getPwd())){
            return user;
        }
        throw new LoginException("用户名或密码错误!");
    }
}
