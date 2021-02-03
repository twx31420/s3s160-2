package edu.nf.library.dao;

import edu.nf.library.entity.BorrowBook;

import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/29
 */
public interface BorrowBookDao {
    /**
     * 查询所有借书记录
     * @return
     */
    List<BorrowBook> listBorrowBook();

    /**
     * 添加借出记录
     * @param book
     */
    void addBorrowBook(BorrowBook book);

    /**
     * 修改借出记录
     * @param book
     */
    void updateBorrowBook(BorrowBook book);
}
