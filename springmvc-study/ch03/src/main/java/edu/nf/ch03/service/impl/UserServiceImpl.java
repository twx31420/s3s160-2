package edu.nf.ch03.service.impl;

import edu.nf.ch03.dao.UserDao;
import edu.nf.ch03.entity.User;
import edu.nf.ch03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 天文学
 * @date 2021/1/1
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public void add(User user) {
        dao.addUser(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void delete(int uid) {
        dao.delete(uid);
    }
}
