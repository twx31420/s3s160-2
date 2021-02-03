package edu.nf.ch04.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/31
 */
@Data
public class User {
    private String userName;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private List<Address> addresses;
}