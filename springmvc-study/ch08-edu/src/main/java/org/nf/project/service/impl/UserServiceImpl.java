package org.nf.project.service.impl;

import org.nf.project.dao.UserDao;
import org.nf.project.entity.User;
import org.nf.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(int uid) {
        return userDao.getUserById(uid);
    }
}
