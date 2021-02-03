package edu.nf.library.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 天文学
 * @date 2020/12/27
 */
@Data
public class BorrowBook {
    private Integer borrowId;
    private Book book;
    private Read read;
    private Integer number;
    private Date borrowDate;
    private Date limitDate;
    private ReturnBook returnBook;
}
