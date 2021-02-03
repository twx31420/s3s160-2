package edu.nf.homework.controller;

import edu.nf.homework.vo.ResultVO;
import org.springframework.http.HttpStatus;

/**
 * @author 天文学
 * @date 2021/1/14
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
     * 成功返回数据的方法
     * @param data
     * @param <T>
     * @return
     */
    public <T>ResultVO<T> success(T data){
        ResultVO<T> vo=new ResultVO<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }
}
