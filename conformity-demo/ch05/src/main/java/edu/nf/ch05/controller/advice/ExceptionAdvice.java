package edu.nf.ch05.controller.advice;

import edu.nf.ch05.exception.LoginException;
import edu.nf.ch05.vo.ResultVO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 天文学
 * @date 2021/1/21
 */
@ControllerAdvice(basePackages = "edu.nf.ch05.controller")
public class ExceptionAdvice {
    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public ResultVO handlerLoginException(LoginException e){
        e.printStackTrace();
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.UNAUTHORIZED.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    /**
     * 这里捕获所有的内部产生的异常信息，进行统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVO hanler(RuntimeException e){
        e.printStackTrace();
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage("服务器异常，请稍后再试！");
        return vo;
    }
}
