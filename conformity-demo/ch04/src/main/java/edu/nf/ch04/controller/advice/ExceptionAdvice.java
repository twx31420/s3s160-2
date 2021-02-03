package edu.nf.ch04.controller.advice;

import edu.nf.ch04.vo.ResultVO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 天文学
 * @date 2021/1/20
 */
@ControllerAdvice(basePackages = "edu.nf.ch04.controller")
public class ExceptionAdvice {
    @ExceptionHandler(PersistenceException.class)
    @ResponseBody
    public ResultVO handlerRersistenceException(PersistenceException e){
        //做日志记录
        e.printStackTrace();
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage("服务器异常，请稍后重试!");
        return vo;
    }
}
