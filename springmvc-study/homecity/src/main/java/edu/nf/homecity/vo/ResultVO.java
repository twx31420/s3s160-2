package edu.nf.homecity.vo;

import lombok.Data;

/**
 * @author 天文学
 * @date 2021/1/17
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private Object message;
    private T data;
}
