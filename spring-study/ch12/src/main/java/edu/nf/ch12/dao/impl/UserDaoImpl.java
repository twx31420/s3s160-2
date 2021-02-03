package edu.nf.ch12.dao.impl;

import edu.nf.ch12.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author 天文学
 * @date 2020/12/4
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("insert into user_info...");
    }

    public void init(){
        System.out.println("执行userDao的init方法");
    }

    public void dectory(){
        System.out.println("执行userDao的dectory方法");
    }
}
