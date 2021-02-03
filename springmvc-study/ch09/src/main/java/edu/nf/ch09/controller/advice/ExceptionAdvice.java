package edu.nf.ch09.controller.advice;

import edu.nf.ch09.exceptioon.DataAccessException;
import edu.nf.ch09.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 天文学
 * @date 2021/1/12
 * 定义一个全局异常处理类（类似一个切面）
 * 这个类中定义的所有方法都是异常处理方法，
 * 也可以理解为是全局的异常通知、
 *
 */
@ControllerAdvice("edu.nf.ch09.controller")
public class ExceptionAdvice {
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public ResultVO handlerDataAccessException(DataAccessException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
