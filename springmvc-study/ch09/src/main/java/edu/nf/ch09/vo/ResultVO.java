package edu.nf.ch09.vo;

import lombok.Data;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@Data
public class ResultVO<T> {

    private Integer code;
    private Object message;
    private T data;
}
