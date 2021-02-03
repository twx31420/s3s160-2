package edu.nf.library.service;

import edu.nf.library.entity.BookType;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/7
 */
public interface BookTypeService {
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
