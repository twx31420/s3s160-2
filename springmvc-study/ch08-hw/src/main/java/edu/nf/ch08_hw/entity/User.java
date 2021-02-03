package edu.nf.ch08_hw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 天文学
 * @date 2021/1/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String user;
    private String pwd;
    private String name;
    private String sex;
    private String image;
}
