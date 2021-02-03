package edu.nf.ch16.service.impl;

import edu.nf.ch16.service.UserService;

/**
 * @author 天文学
 * @date 2020/12/8
 */
public class UserServiceImpl implements UserService {
    @Override
    public String add(String name) {
        System.out.println("添加用户信息....."+name);
        return "add success";
    }

    @Override
    public void delete() {
        System.out.println("删除用户信息...");
    }
}
