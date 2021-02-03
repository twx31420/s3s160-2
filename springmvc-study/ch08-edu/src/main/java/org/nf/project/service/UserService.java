package org.nf.project.service;

import org.nf.project.entity.User;

/**
 * @author 天文学
 * @date 2021/1/12
 */
public interface UserService {

    void addUser(User user);


    User getUserById(int uid);
}
