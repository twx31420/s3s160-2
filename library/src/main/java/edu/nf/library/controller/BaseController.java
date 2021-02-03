package edu.nf.library.controller;

import edu.nf.library.vo.ResultVO;

/**
 * @author 天文学
 * @date 2021/1/7
 */
public abstract class BaseController {

    /**
     * 成功返回数据的方法
     * @param data
     * @param <T>
     * @return
     */
    public <T> ResultVO<T> success(T data) {
        ResultVO<T> vo = new ResultVO<>();
        vo.setCode(200);
        vo.setData(data);
        return vo;
    }

    /**
     * 成功返回信信的方法
     * @return
     */
    public ResultVO success() {
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        return vo;
    }

    /**
     * 失败的方法
     * @param code
     * @param message
     * @return
     */
    public ResultVO fail(int code, String message) {
        ResultVO vo = new ResultVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}
