package edu.nf.ch12.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 天文学
 * @date 2021/1/14
 * 标注在类上，表示当前类所有的方法都支持跨域，标注在方法上表示当前方法支持跨域。
 * 如果需要所有类的所有方法支持跨域，那么可以配置
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
