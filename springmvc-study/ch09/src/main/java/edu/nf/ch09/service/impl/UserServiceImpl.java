package edu.nf.ch09.service.impl;

import edu.nf.ch09.dao.UserDao;
import edu.nf.ch09.entity.User;
import edu.nf.ch09.exceptioon.DataAccessException;
import edu.nf.ch09.service.UserService;
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
        //dao执行可能会引发底层数据库的异常
        //在业务层可以将器捕获并转换位自定义异常对象
        try {
            userDao.save(user);
        } catch (Exception e) {
            //记录异常日志
            e.printStackTrace();
            throw new DataAccessException("数据库访问失败，请联系管理员",e);
        }
    }
}
