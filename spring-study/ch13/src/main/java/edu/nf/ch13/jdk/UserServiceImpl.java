package edu.nf.ch13.jdk;

/**
 * @author 天文学
 * @date 2020/12/7
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户");
    }

    @Override
    public void getUser() {
        System.out.println("查询用户");
    }
}

