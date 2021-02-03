package edu.nf.library.service.impl;

import edu.nf.library.dao.BookTypeDao;
import edu.nf.library.entity.BookType;
import edu.nf.library.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/7
 */
@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeDao bookTypeDao;
    @Override
    public List<BookType> listBookType() {
        return bookTypeDao.listBookType();
    }

    @Override
    public void addBookType(BookType bookType) {
        bookTypeDao.addBookType(bookType);
    }

    @Override
    public void updateBookType(BookType bookType) {
        bookTypeDao.updateBookType(bookType);
    }
}
