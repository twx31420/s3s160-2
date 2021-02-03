package edu.nf.ch02.entity;

import lombok.Data;


/**
 * @author 天文学
 * @date 2021/1/19
 */
@Data
public class City {
    private Integer id;
    private String cityName;
    private String cityCode;
    private String province;
}
