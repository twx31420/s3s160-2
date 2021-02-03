package edu.nf.ch21.job;

import edu.nf.ch21.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 天文学
 * @date 2020/12/9
 * 定时任务处理类
 */
@Component
public class DomeTask {

    /**
     * 定时任务需要反复执行taskservice中的业务逻辑
     * 因此将它注入进来
     */
    @Autowired
    private TaskService service;


    /**
     * 定时备份
     */
    @Scheduled(cron = "0/3 * * * * ?")
    public void executeBackup(){
        service.backup();
    }

    /**
     * 定时清理
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void executeClean(){
        service.clean();
    }

}
