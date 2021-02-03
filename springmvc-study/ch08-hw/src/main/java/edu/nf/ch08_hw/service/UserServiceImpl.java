package edu.nf.ch08_hw.service;

import edu.nf.ch08_hw.dao.UserDaoImpl;
import edu.nf.ch08_hw.entity.User;

/**
 * @author 天文学
 * @date 2021/1/11
 */
public class UserServiceImpl implements UserService{
    @Override
    public void save(User user) {
        new UserDaoImpl().add(user);
    }
}
