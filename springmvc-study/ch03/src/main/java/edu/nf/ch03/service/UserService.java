package edu.nf.ch03.service;

import edu.nf.ch03.entity.User;

/**
 * @author 天文学
 * @date 2020/12/31
 */
public interface UserService {

    void add(User user);

    void update(User user);

    void delete(int uid);
}
