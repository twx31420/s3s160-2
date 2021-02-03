package org.nf.homework.vo;

import lombok.Data;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@Data
public class ResultVo<T> {
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private Object message;
    /**
     * 响应数据
     */
    private T data;
}
