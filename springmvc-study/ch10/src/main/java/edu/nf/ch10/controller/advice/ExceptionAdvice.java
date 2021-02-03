package edu.nf.ch10.controller.advice;

import edu.nf.ch10.exception.LoginException;
import edu.nf.ch10.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 天文学
 * @date 2021/1/13
 */
@ControllerAdvice("edu.nf.ch10.controller")
public class ExceptionAdvice {
    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public ResultVO handlerLoginException(LoginException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.UNAUTHORIZED.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

}
