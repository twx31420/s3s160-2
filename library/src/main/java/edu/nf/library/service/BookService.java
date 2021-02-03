package edu.nf.library.service;

import com.github.pagehelper.PageInfo;
import edu.nf.library.entity.Book;

/**
 * @author 天文学
 * @date 2021/1/7
 */
public interface BookService {

    /**
     * 查询所有图书信息
     * @return
     */
    PageInfo<Book> listBook();

    /**
     * 添加图书信息
     * @param book
     */
    void addBook(Book book);

    /**
     * 修改图书信息
     * @param book
     */
    void updateBook(Book book);
}
