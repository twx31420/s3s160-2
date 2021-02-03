package edu.nf.ch07.controller;

import edu.nf.ch07.entity.User;
import edu.nf.ch07.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/7
 */
@RestController
public class UserController {
    /**
     * 使用@Valid注解标识在实体参数上，表示这个实体内容
     * 需要校验。如果校验不通过，会有验证信息返回，这些验证信息
     * 会保存在一个叫BindingResult的对象上，因此可以从这里面获取
     * 验证信息并返回页面
     * @param user
     * @return
     */
    @PostMapping("/add")
    public ResultVO add(@Valid User user,BindingResult result){
//      如果有错误信息，则获取message属性的信息
        ResultVO vo=new ResultVO();
        //先判断是否有错误信息
        if(result.hasErrors()){
//            创建一个list集合存放错误信息
            List<String> messages=new ArrayList<>();
            for (FieldError fieldError:result.getFieldErrors()){
                messages.add(fieldError.getDefaultMessage());
            }
            //设置转态吗
            vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            //设置消息
            vo.setMessage(messages);
        }else {
            vo.setCode(200);
            vo.setMessage("添加成功");
        }
        return vo;
    }
}
