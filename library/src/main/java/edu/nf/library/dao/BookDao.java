package edu.nf.library.dao;

import edu.nf.library.entity.Book;

import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/29
 */
public interface BookDao {
    /**
     * 查询所有图书
     * @return
     */
    List<Book> listBook();

    /**
     * 添加图书信信
     * @param book
     */
    void addBook(Book book);

    /**
     * 修改图书信息
     * @param book
     */
    void updateBook(Book book);

    /**
     * 删除图书信息
     * @param id
     */
    void deleteBook(int id);

}
