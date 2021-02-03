package edu.nf.library.controller.advice;

import edu.nf.library.exception.LoginException;
import edu.nf.library.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@ControllerAdvice("edu.nf.library.controller")
public class ExceptionAdvice {

    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public ResultVO handlerLoginException(LoginException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.UNAUTHORIZED.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVO handlerRuntimeException(RuntimeException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage("服务器异常，请稍后再试！");
        return vo;
    }


}
