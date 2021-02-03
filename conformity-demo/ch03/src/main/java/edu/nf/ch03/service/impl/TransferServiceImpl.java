package edu.nf.ch03.service.impl;

import edu.nf.ch03.dao.AccountDao;
import edu.nf.ch03.entity.Account;
import edu.nf.ch03.exception.TransferException;
import edu.nf.ch03.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 天文学
 * @date 2021/1/19
 */
@Service("transferService")
/**
 * 事务注解，注解中的属性配置和xml一致
 * 标注在类上面时，表示当前类的所有方法都参与事务，
 * 也可以标注在方法上，表示当前方法参与事务
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class,readOnly = false)
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountDao dao;

    /**
     * 转账
     * 我们应该在transfer方式上加上事务，因为每一个dao的操作都是原子操作
     * 当所有doa执行成功后，事务会被提交，这样可以利用spring提供的声明式事务
     * 来实现。
     * 声明式事务本身基于aop来实现，会在调用业务方法前开启事务，业务方法执行成功后
     * 提交时候，如果执行过程产生异常会自动回滚。
     * @param money 转账金额
     * @param fromUser 转账人
     * @param toUser 接收人
     */
    //@Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class,readOnly = false)
    @Override
    public void transfer(Integer money,Account fromUser, Account toUser) {
        //先检查转账人的余额是否足够
        fromUser=dao.getOverByAccount(fromUser.getAccount());
        //查询接收人的余额信息
        toUser=dao.getOverByAccount(toUser.getAccount());
        if(money > fromUser.getOver()){
            throw new TransferException("对不起，余额不足！");
        }
        //先更新转账人的余额，执行扣除
        fromUser.setOver(fromUser.getOver()-money);
        dao.updateAccount(fromUser);
        /*//引发异常
        System.out.println(10/0);*/
        //在执行接收人的余额，执行增加
        toUser.setOver(toUser.getOver()+money);
        dao.updateAccount(toUser);
    }
}
