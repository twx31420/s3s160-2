package edu.nf.ch05.service;

import edu.nf.ch05.entity.User;

/**
 * @author 天文学
 * @date 2021/1/21
 */
public interface UserService {
    /**
     * 验证用户账号
     * @param user
     * @return
     */
    User check(User user);

}
