package edu.nf.ch09_hw.service.impl;

import edu.nf.ch09_hw.dao.UserDao;
import edu.nf.ch09_hw.entity.User;
import edu.nf.ch09_hw.exception.LoginException;
import edu.nf.ch09_hw.exception.SqlDataAccessException;
import edu.nf.ch09_hw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        User user1=userDao.login(user);
        if (user1!=null && user.getName().equals(user1.getName())){
            return user1;
        }else {
            throw  new LoginException("用户名或密码错误！");
        }
    }

    @Override
    public void save(User user) {
        try {
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SqlDataAccessException("数据库异常，请联系管理员");
        }
    }

    @Override
    public List<User> getList() {
        try {
            return userDao.getList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SqlDataAccessException("数据库异常，请联系管理员");
        }
    }

    @Override
    public void update(User user) {
        try {
            userDao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SqlDataAccessException("数据库异常，请联系管理员");
        }
    }

    @Override
    public void delete(int id) {
        try {
            userDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SqlDataAccessException("数据库异常，请联系管理员");
        }
    }
}
