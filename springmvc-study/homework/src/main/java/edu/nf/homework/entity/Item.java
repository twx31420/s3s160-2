package edu.nf.homework.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@Data
public class Item {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Type type;
}
