package edu.nf.ch09_hw.controller.advice;

import edu.nf.ch09_hw.exception.LoginException;
import edu.nf.ch09_hw.exception.SqlDataAccessException;
import edu.nf.ch09_hw.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@ControllerAdvice("edu.nf.ch09_hw.controller")
public class ExceptionAdvice {

    @ExceptionHandler(SqlDataAccessException.class)
    @ResponseBody
    public ResultVO exception(SqlDataAccessException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public ResultVO handlerLoginException(LoginException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.UNAUTHORIZED.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
