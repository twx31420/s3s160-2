package edu.nf.homework.service.impl;

import edu.nf.homework.dao.UserDao;
import edu.nf.homework.entity.User;
import edu.nf.homework.service.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/21
 */
public class UserService implements Service {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> query() {
        return userDao.select();
    }
}
