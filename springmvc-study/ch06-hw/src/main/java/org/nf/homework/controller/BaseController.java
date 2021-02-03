package org.nf.homework.controller;

import org.nf.homework.vo.ResultVo;


/**
 * @author 天文学
 * @date 2021/1/6
 */
public class BaseController {

    public <T> ResultVo<T> success(T data){
        ResultVo<T> vo=new ResultVo();
        vo.setCode(200);
        vo.setData(data);
        return vo;
    }

    public ResultVo success(String message){
        ResultVo vo=new ResultVo();
        vo.setCode(200);
        vo.setMessage(message);
        return vo;
    }

    public ResultVo fail(int code,Object message){
        ResultVo vo=new ResultVo();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}
