package edu.nf.ch04_1.controller.advice;

import edu.nf.ch04_1.vo.ResultVO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 天文学
 * @date 2021/1/20
 */
@ControllerAdvice(basePackages = "edu.nf.ch04_1.controller")
public class RuntimeExceptionAdvice {
    @ExceptionHandler(PersistenceException.class)
    @ResponseBody
    public ResultVO handler(PersistenceException e){
        e.printStackTrace();
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage("服务器异常，请稍后再试！");
        return vo;
    }
}
