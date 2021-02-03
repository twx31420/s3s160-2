package edu.nf.ch03.service;

import edu.nf.ch03.entity.Account;

/**
 * @author 天文学
 * @date 2021/1/19
 * 转账业务实现
 */
public interface TransferService {
    /**
     * 转账
     * @param fromUser 转账人
     * @param toUser 接收人
     */
    void transfer(Integer money,Account fromUser,Account toUser);
}
