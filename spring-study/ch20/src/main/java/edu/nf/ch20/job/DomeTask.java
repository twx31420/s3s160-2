package edu.nf.ch20.job;

import edu.nf.ch20.service.TaskService;

/**
 * @author 天文学
 * @date 2020/12/9
 * 定时任务处理类
 */
public class DomeTask {

    private TaskService service;

    /**
     * 定时任务需要反复执行taskservice中的业务逻辑
     * 因此将它注入进来
     */
    public void setService(TaskService service) {
        this.service = service;
    }

    /**
     * 定时备份
     */
    public void executeBackup(){
        service.backup();
    }

    /**
     * 定时清理
     */
    public void executeClean(){
        service.clean();
    }

}
