package edu.nf.library.service;

import edu.nf.library.entity.Read;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/7
 */
public interface ReadService {
    /**
     * 查询所有用户信信
     * @return
     */
    List<Read>  listRead();

    /**
     * 添加用户信息
     * @param read
     */
    void addRead(Read read);

    /**]
     * 修改用户信息
     * @param read
     */
    void updateRead(Read read);


}
