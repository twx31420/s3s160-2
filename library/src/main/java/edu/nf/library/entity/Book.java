package edu.nf.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

/**
 * @author 天文学
 * @date 2020/12/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer bookId;
    private String bookName;
    private String press;
    private String author;
    private String introduction;
    private BigDecimal price;
    private Integer inventory;
    private BookType bookType;
    private String location;
}
