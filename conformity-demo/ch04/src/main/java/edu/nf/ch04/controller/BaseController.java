package edu.nf.ch04.controller;

import edu.nf.ch04.vo.ResultVO;
import org.springframework.http.HttpStatus;

/**
 * @author 天文学
 * @date 2021/1/20
 */
public class BaseController {

    public <T> ResultVO<T> success(T data){
        ResultVO<T> vo=new ResultVO<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }

    public ResultVO fail(Integer code,String message){
        ResultVO vo=new ResultVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}
