package org.nf.project.vo;

import lombok.Data;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@Data
public class ResultVo<T> {

    private Integer code;
    private Object message;
    private T data;
}
