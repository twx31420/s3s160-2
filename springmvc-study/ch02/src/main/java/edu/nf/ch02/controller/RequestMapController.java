package edu.nf.ch02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 天文学
 * @date 2020/12/31
 */
@Controller
@RequestMapping("/user")
public class RequestMapController {

    /**
     * method指定可以支持的请求处理方法，它是一个数组
     * 可以通过requestMethod来指定。
     * 不指定method默认支持所有的请求方法。
     * @return
     */
    @RequestMapping(value = "getuser",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getUser(){
        System.out.println("get user...");
        return new ModelAndView("index");
    }
    /**
     * 从springmvc4.0之后，加入了更为明确的注解来标识
     * 列如：@PostMapping标识支持post请求方法
     * @getmapping标识支持get请求等等。
     * 这些注解只能用于方法上
     */
    @GetMapping("/getuser2")
    @PostMapping("/getuser2")
    public ModelAndView getUser2(){
        System.out.println("get user2...");
        return new ModelAndView("index");
    }



}
