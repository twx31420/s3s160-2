package edu.nf.ch05.vo;

import lombok.Data;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@Data
public class ResultVO<T> {

    private Integer code;
    private Object message;
    private T data;
}
