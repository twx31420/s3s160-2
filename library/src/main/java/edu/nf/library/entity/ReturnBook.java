package edu.nf.library.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 天文学
 * @date 2020/12/27
 */
@Data
public class ReturnBook {
    private Integer borrowId;
    private Date returnDate;
    private Integer returnNum;
    private State state;
}
