package edu.nf.library.dao;

import edu.nf.library.entity.Read;

import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/29
 */
public interface ReadDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<Read> listRead();

    /**
     * 添加用户信息
     * @param read
     */
    void addRead(Read read);

    /**
     * 修改用户信息
     * @param read
     */
    void updateRead(Read read);


}
