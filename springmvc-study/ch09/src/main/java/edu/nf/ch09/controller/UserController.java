package edu.nf.ch09.controller;

import edu.nf.ch09.entity.User;
import edu.nf.ch09.exceptioon.DataAccessException;
import edu.nf.ch09.service.UserService;
import edu.nf.ch09.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    public UserService service;


    /**
     * 局部异常处理
     *
     * @ExceptionHandler注解标注的方法专门用于处理抛出的异常。
     * value属性执行异常的Class对象，（是一个数组，可以同时指定多个异常）
     * 表示铺货什么样的异常对象，最后会将这个异常对象传入到标注的放单费参数中
     * 注意：@ExceptionHandler标注的方法只在当前的controller类中有效
     * 也就是只在当前类的范围内有效，这就是局部的概念，如果想让所有类都共享
     * 这个异常处理方法，那么就必须使用全局的异常处理
     * @param e
     * @return
     */
   /* @ExceptionHandler(DataAccessException.class)
    public ResultVO handlerException(DataAccessException e){
        ResultVO vo=new ResultVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }*/


    @PostMapping("/add")
    public ResultVO addUser(User user){
            service.addUser(user);
            return success();
    }
}
