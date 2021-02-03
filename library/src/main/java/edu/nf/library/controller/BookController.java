package edu.nf.library.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.library.entity.Book;
import edu.nf.library.service.BookService;
import edu.nf.library.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 天文学
 * @date 2021/1/7
 */
@RestController
public class BookController extends BaseController{

    @Autowired
    private BookService bookService;

    @GetMapping("/book/list")
    public ResultVO listBook(){
        PageInfo<Book> pageInfo= bookService.listBook();
        return success(pageInfo);
    }

    @PostMapping("/book/add")
    public ResultVO addBook(Book book){
        bookService.addBook(book);
        return success();
    }

    @PostMapping("/book/update")
    public ResultVO updateBook(Book book){
        bookService.updateBook(book);
        return success();
    }


}
