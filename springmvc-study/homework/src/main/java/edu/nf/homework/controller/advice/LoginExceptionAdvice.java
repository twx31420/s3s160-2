package edu.nf.homework.controller.advice;


import edu.nf.homework.exception.LoginException;
import edu.nf.homework.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@ControllerAdvice("edu.nf.homework.controller")
public class LoginExceptionAdvice{
    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public ResultVO hendlerLoginException(LoginException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.UNAUTHORIZED.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

}
