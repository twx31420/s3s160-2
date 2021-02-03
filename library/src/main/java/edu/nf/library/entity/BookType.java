package edu.nf.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 天文学
 * @date 2020/12/27
 */
@Data
@AllArgsConstructor
public class BookType {
    private Integer typeId;
    private String typeName;
}
