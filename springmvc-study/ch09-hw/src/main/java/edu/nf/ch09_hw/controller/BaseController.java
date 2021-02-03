package edu.nf.ch09_hw.controller;

import edu.nf.ch09_hw.vo.ResultVO;
import org.springframework.http.HttpStatus;

/**
 * @author 天文学
 * @date 2021/1/12
 */
public class BaseController {
    /**
     * 成功的方法
     * @return
     */
    public ResultVO success(){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.OK.value());
        return vo;
    }

    /**
     * 成功放回数据
     * @param data
     * @param <T>
     * @return
     */
    public <T> ResultVO<T> success(T data){
        ResultVO<T> vo=new ResultVO<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }

    /**
     * 失败的方法
     * @param message
     * @return
     */
    public ResultVO fail(Object message){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(message);
        return vo;
    }
}
