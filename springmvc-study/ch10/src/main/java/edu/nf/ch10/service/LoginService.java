package edu.nf.ch10.service;

import edu.nf.ch10.entity.User;
/**
 * @author 天文学
 * @date 2021/1/13
 */
public interface LoginService {
    /**
     * 登入校验
     * @param userName
     * @param pwd
     */
    User check(String userName, String pwd);
}
