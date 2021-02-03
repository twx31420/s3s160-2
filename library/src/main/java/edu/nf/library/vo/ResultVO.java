package edu.nf.library.vo;

import lombok.Data;

/**
 * @author 天文学
 * @date 2021/1/7
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private Object message;
    private T data;
}
