package edu.nf.library.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.library.dao.BookDao;
import edu.nf.library.entity.Book;
import edu.nf.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/7
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @GetMapping("/book/list")
    @Override
    public PageInfo<Book> listBook() {
        List<Book>list=bookDao.listBook();
        PageInfo<Book> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @PostMapping("/book/add")
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @PostMapping("/book/update")
    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }


}
