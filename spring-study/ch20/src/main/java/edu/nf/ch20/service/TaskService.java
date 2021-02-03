package edu.nf.ch20.service;

/**
 * @author 天文学
 * @date 2020/12/9
 */
public interface TaskService {
    /**
     * 定时备份
     */
    void backup();

    /**
     * 定时清理
     */
    void clean();
}
