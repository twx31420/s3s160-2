package edu.nf.library.dao;

import edu.nf.library.entity.BookType;

import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/29
 */
public interface BookTypeDao {
    /**
     * 查询所有图书类型
     * @return
     */
    List<BookType> listBookType();

    /**
     * 添加图书信息
     * @param bookType
     */
    void addBookType(BookType bookType);

    /**
     * 修改图书信息
     * @param bookType
     */
    void updateBookType(BookType bookType);
}
