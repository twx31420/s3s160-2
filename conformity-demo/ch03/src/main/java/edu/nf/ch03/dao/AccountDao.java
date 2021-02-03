package edu.nf.ch03.dao;

import edu.nf.ch03.entity.Account;

/**
 * @author 天文学
 * @date 2021/1/19
 */
public interface AccountDao {
    /**
     * 根据账号查询余额
     * @param account
     * @return
     */
    Account getOverByAccount(String account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
