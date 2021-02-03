package edu.nf.ch03.test;

import edu.nf.ch03.entity.Account;
import edu.nf.ch03.service.TransferService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 天文学
 * @date 2021/1/19
 */
public class TransferServiceTest {
    @Test
    public void testTransfer(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext2.xml");
        TransferService service=context.getBean("transferService",TransferService.class);
        //创建转账人账号
        Account fromUser=new Account();
        fromUser.setAccount("A1000001");

        //创建接收人
        Account toUser=new Account();
        toUser.setAccount("A1000002");
        //执行转账
        service.transfer(200,fromUser,toUser);
    }
}
