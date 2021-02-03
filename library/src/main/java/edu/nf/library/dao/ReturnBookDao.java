package edu.nf.library.dao;

import edu.nf.library.entity.ReturnBook;

import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/29
 */
public interface ReturnBookDao {
    /**
     * 查询所有还书记录
     * @return
     */
    List<ReturnBook> listReturnBook();

    /**
     * 添加还书信息记录
     * @param returnBook
     */
    void addReturnBook(ReturnBook  returnBook);

    /**
     * 修改还书信息记录
     * @param returnBook
     */
    void updateReturnBook(ReturnBook returnBook);
}
