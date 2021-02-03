package edu.nf.library.test;

import edu.nf.library.config.AppConfig;
import edu.nf.library.entity.Book;
import edu.nf.library.entity.BookType;
import edu.nf.library.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;


/**
 * @author 天文学
 * @date 2021/1/7
 */
public class BookServiceTest {
    @Test
    public void testListBook(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        BookService service=context.getBean("bookService",BookService.class);
        service.listBook().getList().forEach(b->{
            System.out.println(b.getBookName());
        });
    }
    @Test
    public void testAddBook(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        BookService service=context.getBean("bookService",BookService.class);
        Book book=new Book(null,"Mysql","人民出版社",
                "xxx","关于mysql基础", BigDecimal.valueOf(35),37,
                new BookType(2,null),"a区21号");
        service.addBook(book);

    }
    @Test
    public void testUpdateBook(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        BookService service=context.getBean("bookService",BookService.class);
        Book book=new Book(3,"Mysql","人民出版社",
                "xxx","关于mysql基础", BigDecimal.valueOf(35),37,
                new BookType(2,null),"a区21号");
        service.updateBook(book);
    }

}
