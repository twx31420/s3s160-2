package edu.nf.library.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/27
 */
@Data
public class Read {
    private Integer id;
    private String rid;
    private String rpwd;
    private String rname;
    private String rsex;
    private String rcard;
    private String rtel;
    private String address;
    private List<BorrowBook> borrowBooks=new ArrayList<>();

}
