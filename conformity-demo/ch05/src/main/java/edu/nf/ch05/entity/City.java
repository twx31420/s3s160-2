package edu.nf.ch05.entity;

import lombok.Data;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@Data
public class City {
    private Integer id;
    private String cityName;
    private String cityCode;
    private String province;
}
